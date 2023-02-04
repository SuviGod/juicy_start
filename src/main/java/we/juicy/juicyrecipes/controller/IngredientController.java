package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.domain.IngredientCategory;
import we.juicy.juicyrecipes.service.IngredientCategoryService;
import we.juicy.juicyrecipes.service.IngredientService;

import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    private final IngredientCategoryService ingredientCategoryService;

    @GetMapping(value ="/all")
    public String showAllIngredients(@RequestParam(required = false) String category, Model model){
        log.info("Requesting for all ingredient categories");
        Set <IngredientCategory> ingredientCategories = ingredientCategoryService.findAll();
        model.addAttribute("categories", ingredientCategories);

        if (StringUtils.isEmptyOrWhitespace(category)) {
            log.info("Requesting for all ingredients");
            Set<Ingredient> allIngredients = ingredientService.findAll();
            model.addAttribute("ingredients", allIngredients);
            log.info("going into ingredient/all");
            return "ingredient/all";
        }

        log.info("Requesting for all ingredients for group {}", category);
        Set<Ingredient> allIngredients = ingredientService.findAllByCategory(category);
        model.addAttribute("ingredients", allIngredients);
        log.info("going into ingredient/all with category");
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

    @GetMapping(value = "/new")
    public String createIngredientForm(Model model){
        model.addAttribute("ingredient", new Ingredient());
        log.info("In ingredient/new endpoint");
        return "ingredient/creation_form";
    }

    @PostMapping(value = "/")
    public String updateIngredient(@ModelAttribute Ingredient ingredientToUpdate){
        log.info("In ingredient post mapping method - creating new ingredient");
        Ingredient updatedIngredient = ingredientService.updateIngredient(ingredientToUpdate);
        return "redirect:/ingredient/" + updatedIngredient.getId() + "/show";
    }
}
