package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import we.juicy.juicyrecipes.domain.IngredientCategory;
import we.juicy.juicyrecipes.domain.IngredientIngredientCategory;
import we.juicy.juicyrecipes.service.IngredientIngredientCategoryService;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ingredient-ingredient-category")
public class IngredientIngredientCategoryController {
    private final IngredientIngredientCategoryService ingredientIngredientCategoryService;

    @GetMapping("/delete")
    public String deleteIngredientCategoryRelation(@RequestParam Integer categoryId, @RequestParam Integer ingredientId){
        log.info("In ingredient category relation /delete post mapping method ");
        ingredientIngredientCategoryService.deleteByCategoryIdAndIngredientId(categoryId, ingredientId);
        return "redirect:/ingredient/" + ingredientId + "/show";
    }
}
