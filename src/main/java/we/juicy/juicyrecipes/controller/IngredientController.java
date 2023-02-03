package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.service.IngredientService;

import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping(value ="/all")
    public String showAllIngredients(Model model){

        log.info("Requesting for all ingredients");
        Set<Ingredient> allIngredients = ingredientService.findAll();
        model.addAttribute("ingredients", allIngredients);
        return "ingredient/all";
    }


    @GetMapping(value = "/{id}/show")
    public String showById(@PathVariable("id") Integer id, Model model ){
        log.info("Requesting for ingredient with id -> {}", id);
        Optional<Ingredient> maybeIngredient = ingredientService.findById(id);
        if (maybeIngredient.isPresent()) {
            Ingredient ingredient = maybeIngredient.get();
            model.addAttribute("indredient", ingredient);
            return "ingredient/show";
        }

        return "error";
    }
}
