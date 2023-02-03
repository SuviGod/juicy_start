package we.juicy.juicyrecipes.preload;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.domain.Difficulty;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.domain.TypeOfMeasure;
import we.juicy.juicyrecipes.repository.ContentsRepository;
import we.juicy.juicyrecipes.repository.IngredientRepository;
import we.juicy.juicyrecipes.repository.RecipeRepository;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipePreload implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final ContentsRepository contentsRepository;
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getDefaultRecipes());
        userRepository.save(createBaseUser());
    }

    private List<Recipe> getDefaultRecipes() {
        Recipe applePie = Recipe.builder()
                .id(1)
                .name("Cake with apples")
                .description("Buy cake with Apples")
                .difficulty(Difficulty.EASY)
                .necessaryAmount(new ArrayList<>())
                .build();
        Recipe orangePie = Recipe.builder().id(2).name("Cake with oranges").description("Buy cake Oranges").difficulty(Difficulty.EASY).build();
        Recipe pearPie = Recipe.builder().id(3).name("Cake with birnes").description("Buy cake with Birnes").difficulty(Difficulty.EASY).build();

        recipeRepository.save(applePie);
        recipeRepository.save(orangePie);
        recipeRepository.save(pearPie);

        Ingredient appleIngredient = Ingredient.builder().id(1).type(TypeOfMeasure.POINTS).name("Apple").build();
        ingredientRepository.save(appleIngredient);
        Contents appleContentsIngredient = Contents.builder().ingredient(appleIngredient).recipe(applePie).amount(1).id(1).build();
        contentsRepository.save(appleContentsIngredient);

        return List.of(applePie, orangePie, pearPie);
    }

    private RecipeUser createBaseUser() {
        return RecipeUser.builder().id(1).name("Pupa").build();
    }

    private List<Recipe> loadSomeRecipes() {
        // GET Recipes (RestTemplate)
        // deparse information
        // creating for 10 Recipe`s
        // return recipes

        return Collections.emptyList();
    }
}
