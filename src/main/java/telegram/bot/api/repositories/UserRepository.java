package telegram.bot.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import telegram.bot.api.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
