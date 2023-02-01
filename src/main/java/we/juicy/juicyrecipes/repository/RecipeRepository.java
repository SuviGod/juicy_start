package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import we.juicy.juicyrecipes.domain.Recipe;
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Recipe findOneByName(String name);
}
