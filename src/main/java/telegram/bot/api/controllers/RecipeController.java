package telegram.bot.api.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import telegram.bot.api.responses.RecipeResponse;
import telegram.bot.api.services.RecipeService;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    RecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<RecipeResponse>> findByName(@RequestParam List<String> name) {
        return ResponseEntity.ok(recipeService.findByName(name));
    }

    @GetMapping("/category")
    public ResponseEntity<List<RecipeResponse>> findByCategory(@RequestParam String categoryName) {
        return ResponseEntity.ok(recipeService.findByCategory(categoryName));
    }

    @GetMapping("/area")
    public ResponseEntity<List<RecipeResponse>> findByArea(@RequestParam String areaName) {
        return ResponseEntity.ok(recipeService.findByArea(areaName));
    }
}
