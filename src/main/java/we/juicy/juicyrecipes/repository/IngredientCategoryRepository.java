package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import we.juicy.juicyrecipes.domain.IngredientCategory;

public interface IngredientCategoryRepository extends CrudRepository <IngredientCategory, Integer> {

    IngredientCategory findByName(String category);
}
