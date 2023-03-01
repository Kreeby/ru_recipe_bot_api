package telegram.bot.api.services;

import org.springframework.data.domain.Page;
import telegram.bot.api.responses.RecipeResponse;

import java.util.List;

public interface RecipeService {

    Page<RecipeResponse> findAll();
    RecipeResponse findById(Long id);
    List<RecipeResponse> findByName(List<String> name);
    List<RecipeResponse> findByCategory(String categoryName);
    List<RecipeResponse> findByArea(String areaName);
}
