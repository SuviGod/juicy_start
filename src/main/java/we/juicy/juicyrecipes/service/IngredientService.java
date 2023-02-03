package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.domain.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IngredientService {
    Optional<Ingredient> findById(Integer id);

    List<Ingredient> findAllIngredients ();

    Set<Ingredient> findAll();

    Ingredient updateIngredient(Ingredient ingredientToUpdate);
}
