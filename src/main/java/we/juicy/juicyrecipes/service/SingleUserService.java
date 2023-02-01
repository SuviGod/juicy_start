package we.juicy.juicyrecipes.service;

import we.juicy.juicyrecipes.domain.RecipeUser;

import java.util.Optional;

public interface SingleUserService {
    // 
    Optional<RecipeUser> getCurrentUser();
}
