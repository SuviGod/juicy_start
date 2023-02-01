package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import we.juicy.juicyrecipes.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
