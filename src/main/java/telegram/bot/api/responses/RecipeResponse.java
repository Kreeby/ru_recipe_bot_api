package telegram.bot.api.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class RecipeResponse {
    Long id;
    String name;
    String instructions;
    String imageUrl;
    String videoUrl;
    String category;
    String area;
}
