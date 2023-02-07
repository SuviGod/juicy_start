package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import we.juicy.juicyrecipes.domain.Recipe;

import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    Recipe findOneByName(String name);
    Set<Recipe> findByOrderByDifficulty();
}
