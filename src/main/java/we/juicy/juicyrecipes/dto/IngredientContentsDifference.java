package we.juicy.juicyrecipes.dto;

import lombok.Data;
import we.juicy.juicyrecipes.domain.Ingredient;

@Data
public class IngredientContentsDifference {

    private Ingredient ingredient;
    private Integer difference;

}
