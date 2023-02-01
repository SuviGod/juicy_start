package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.service.RecipeService;

import java.util.Optional;
import java.util.Set;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getRecipe(Model model) {
        log.info("Requesting for all recipes");
        Set<Recipe> allRecipes = recipeService.findAll();
        model.addAttribute("recipes", allRecipes);
        return "recipe/all";
    }

    @GetMapping("/{id}/show")
    public String getRecipeById(@PathVariable("id") Integer id, Model model) {
        log.info("Requesting for recipe with id -> {}", id);
        Optional<Recipe> maybeRecipe = recipeService.findById(id);
        if (maybeRecipe.isPresent()) {
            Recipe recipe = maybeRecipe.get();
            model.addAttribute("recipe", recipe);
            return "recipe/show";
        }

        return "error";
    }

    @GetMapping(value = "/byName/{name}")
    //можливість перегляду рецепту обраної страви;
    public Recipe getRecipeByName(@PathVariable("name") String name){
        return recipeService.findOneByName(name);
    }

}
