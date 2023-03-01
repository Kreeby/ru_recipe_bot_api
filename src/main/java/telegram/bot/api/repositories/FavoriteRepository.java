package telegram.bot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import telegram.bot.api.models.FavoriteEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
}
