package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.repository.ContentsRepository;
import we.juicy.juicyrecipes.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ContentsRepository contentsRepository;

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

    @Transactional
    @Override
    public Recipe addIngredient(Integer recipeId, Contents contents) {
        Optional<Recipe> maybeRecipe = recipeRepository.findById(recipeId);
        if (maybeRecipe.isEmpty())
            throw new RuntimeException("Recipe with id is not found");

        Recipe recipe = maybeRecipe.get();
        contents.setRecipe(recipe);

        Contents savedContents = contentsRepository.save(contents);
        recipe.addContents(savedContents);
        return recipeRepository.save(recipe);
    }

    @Transactional
    @Override
    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }



}
