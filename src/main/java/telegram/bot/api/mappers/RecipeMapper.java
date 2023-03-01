package telegram.bot.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import telegram.bot.api.models.RecipeEntity;
import telegram.bot.api.responses.RecipeResponse;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {LocalDateTime.class})
public interface RecipeMapper {

    @Mapping(target = "category", source = "categoryEntity.name")
    @Mapping(target = "area", source = "areaEntity.name")
    RecipeResponse toResponse(RecipeEntity recipeEntity);

    List<RecipeResponse> toResponseList(List<RecipeEntity> recipeEntities);
}

