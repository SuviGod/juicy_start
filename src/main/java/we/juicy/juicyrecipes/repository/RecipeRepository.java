package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import we.juicy.juicyrecipes.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    Recipe findOneByName(String name);
}
