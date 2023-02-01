package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import we.juicy.juicyrecipes.service.IngredientServiceImpl;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientServiceImpl ingredientService;

    @GetMapping(value ="/all")
    public String showAllIngredients(){

        return ingredientService.getAllIngredients().toString();
    }
}
