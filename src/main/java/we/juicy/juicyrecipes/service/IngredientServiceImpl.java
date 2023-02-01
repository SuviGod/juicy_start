package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.repository.IngredientRepository;

import java.util.List;

@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients (){
        return (List<Ingredient>) ingredientRepository.findAll();
    }
}
