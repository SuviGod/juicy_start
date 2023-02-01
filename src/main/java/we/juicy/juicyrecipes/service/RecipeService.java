package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAll();
    Optional<Recipe> findById(Integer id);
    Recipe findOneByName(String name);
}
