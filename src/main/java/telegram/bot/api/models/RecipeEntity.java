package telegram.bot.api.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(indexName = "recipes")
@Entity
@Table(name = "recipes")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    Long id;

    @Column(name = "recipe_name")
    String name;

    @Column(name = "instructions")
    String instructions;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "video_url")
    String videoUrl;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    CategoryEntity categoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    AreaEntity areaEntity;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    List<FavoriteEntity> favorites;
}
