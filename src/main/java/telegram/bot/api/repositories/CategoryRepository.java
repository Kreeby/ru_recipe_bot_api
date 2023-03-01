package telegram.bot.api.repositories;

import org.springframework.data.repository.CrudRepository;
import telegram.bot.api.models.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String name);
}
