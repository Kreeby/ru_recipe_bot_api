package telegram.bot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import telegram.bot.api.models.AreaEntity;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
    AreaEntity findByName(String strArea);
}
