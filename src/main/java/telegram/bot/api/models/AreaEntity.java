package telegram.bot.api.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "areas")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    Long id;

    @Column(name = "area_name")
    String name;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updated_at;

    @OneToMany(mappedBy = "areaEntity")
    Set<RecipeEntity> recipeEntities;
}
