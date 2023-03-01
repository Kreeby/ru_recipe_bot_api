package telegram.bot.api.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import telegram.bot.api.mappers.RecipeMapper;
import telegram.bot.api.repositories.RecipeRepository;
import telegram.bot.api.responses.RecipeResponse;
import telegram.bot.api.services.RecipeService;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    RecipeRepository recipeRepository;
    RecipeMapper recipeMapper;

    @Override
    public Page<RecipeResponse> findAll() {
        return null;
    }

    @Override
    public RecipeResponse findById(Long id) {
        return null;
    }

    @Override
    public List<RecipeResponse> findByName(List<String> name) {
        log.info("Getting recipes by name or search term name: {}", name);
//        List<RecipeEntity> recipeEntities = recipeRepository.findByNameContainingIgnoreCase(name);
        return recipeMapper.toResponseList(new ArrayList<>());
    }

    @Override
    public List<RecipeResponse> findByCategory(String categoryName) {
        return null;
    }

    @Override
    public List<RecipeResponse> findByArea(String areaName) {
        return null;
    }
}
