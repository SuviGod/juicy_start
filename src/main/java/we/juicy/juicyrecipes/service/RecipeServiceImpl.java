package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.repository.RecipeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;



    @Override
    public Recipe findOneByName(String name) {
        return recipeRepository.findOneByName(name);
    }
}
