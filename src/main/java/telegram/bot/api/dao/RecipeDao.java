package telegram.bot.api.dao;

import telegram.bot.api.models.RecipeEntity;

import java.io.IOException;
import java.util.List;

public interface RecipeDao {
    List<RecipeEntity> findSimilarRecipes(List<String> searchTerms) throws IOException;
}
