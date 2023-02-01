package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Optional<Recipe> findById(Integer id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe findOneByName(String name) {
        return recipeRepository.findOneByName(name);
    }
}
