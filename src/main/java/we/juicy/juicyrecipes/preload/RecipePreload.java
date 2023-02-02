package we.juicy.juicyrecipes.preload;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import we.juicy.juicyrecipes.domain.Difficulty;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecipePreload implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getDefaultRecipes());
    }

    private List<Recipe> getDefaultRecipes() {
        Recipe applePie = Recipe.builder().id(1).name("Cake with apples").description("Buy cake with Apples").difficulty(Difficulty.EASY).build();
        Recipe orangePie = Recipe.builder().id(2).name("Cake with oranges").description("Buy cake Oranges").difficulty(Difficulty.EASY).build();
        Recipe birnePie = Recipe.builder().id(3).name("Cake with birnes").description("Buy cake with Birnes").difficulty(Difficulty.EASY).build();

        return List.of(applePie, orangePie, birnePie);
    }
}
