package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.domain.RecipeUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<RecipeUser> findById(Integer id);
    void saveProfile(RecipeUser recipeUser);
}
