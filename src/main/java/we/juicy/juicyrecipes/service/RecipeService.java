package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Recipe;

public interface RecipeService {

    Recipe findOneByName(String name);
}
