package telegram.bot.api.dao.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import telegram.bot.api.dao.RecipeDao;
import telegram.bot.api.models.RecipeEntity;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RecipeDaoImpl implements RecipeDao {

    RestHighLevelClient elasticsearchClient;
    ObjectMapper objectMapper;

    @Override
    public List<RecipeEntity> findSimilarRecipes(List<String> searchTerms) throws IOException {
        // build the query
        QueryBuilder query = null;

        // create the search request
        SearchRequest searchRequest = new SearchRequest("recipes")
                .source(new SearchSourceBuilder().query(query));

        // execute the search request
        SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

        // process the search response and return the results
        return Arrays.stream(searchResponse.getHits().getHits())
                .map(hit -> {
                    try {
                        return objectMapper.readValue(hit.getSourceAsString(), RecipeEntity.class);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to deserialize search hit", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
