package we.juicy.juicyrecipes.preload;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.domain.Difficulty;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.domain.IngredientCategory;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.domain.TypeOfMeasure;
import we.juicy.juicyrecipes.repository.ContentsRepository;
import we.juicy.juicyrecipes.repository.IngredientCategoryRepository;
import we.juicy.juicyrecipes.repository.IngredientRepository;
import we.juicy.juicyrecipes.repository.RecipeRepository;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipePreload implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final ContentsRepository contentsRepository;
    private final UserRepository userRepository;

    private final IngredientCategoryRepository ingredientCategoryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getDefaultRecipes());
        ingredientCategoryRepository.saveAll(createDefaultIngredientCategories());
        ingredientRepository.saveAll(createIngredientsWithCategory());
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
        Contents appleContentsIngredient = Contents.builder().ingredient(appleIngredient).recipe(applePie).amount(new BigDecimal(1)).id(1).build();
        contentsRepository.save(appleContentsIngredient);

        Ingredient orangeIngredient = Ingredient.builder().id(2).type(TypeOfMeasure.POINTS).name("Orange").build();
        ingredientRepository.save(orangeIngredient);
        Contents orangeContentsIngredient = Contents.builder().ingredient(orangeIngredient).recipe(orangePie).amount(new BigDecimal(2)).id(2).build();
        contentsRepository.save(orangeContentsIngredient);

        return List.of(applePie, orangePie, pearPie);
    }

    private List<IngredientCategory> createDefaultIngredientCategories(){
        IngredientCategory fruits = IngredientCategory.builder()
                .ingredients(ingredientRepository.findAllByIdLessThan(2))
                .name("fruits").id(1).build();
        return List.of(fruits);
    }

    private List<Ingredient> createIngredientsWithCategory(){
        List<IngredientCategory> allIngredients = ingredientCategoryRepository.findAll();
        Ingredient cherry = Ingredient.builder()
                .categories(allIngredients)
                .id(3)
                .name("cherry")
                .type(TypeOfMeasure.POINTS)
                .build();
        ingredientRepository.save(cherry);
        allIngredients.stream().peek(it -> it.getIngredients().add(cherry)).forEach(ingredientCategoryRepository::save);
        return List.of(cherry);
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
