package telegram.bot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import telegram.bot.api.models.RecipeEntity;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    List<RecipeEntity> findByNameContainingIgnoreCase(String name);
}
