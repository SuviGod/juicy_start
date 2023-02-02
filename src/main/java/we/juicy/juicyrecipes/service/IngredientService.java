package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    Optional<Ingredient> findById(Integer id);

    List<Ingredient> findAllIngredients ();
}
