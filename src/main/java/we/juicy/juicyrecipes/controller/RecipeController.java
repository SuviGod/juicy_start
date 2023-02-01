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


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/recipe")
public class RecipeController {
    private final RecipeService recipeService;


    @RequestMapping(value = "/cake", method = RequestMethod.GET)
    public String getRecipe(Model model) {
        log.info("requesting for apple cake");
        return "index.html";
    }

    @GetMapping(value = "/byName/{name}")
    //можливість перегляду рецепту обраної страви;
    public Recipe getRecipeByName(@PathVariable("name") String name){
        return recipeService.findOneByName(name);
    }

}
