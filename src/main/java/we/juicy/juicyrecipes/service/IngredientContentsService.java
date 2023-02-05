package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.Contents;

public interface IngredientContentsService {
    void addForRecipe(Contents contents);
    void addForUser(Contents contents);
}
