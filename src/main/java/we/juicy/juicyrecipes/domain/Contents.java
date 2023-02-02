package we.juicy.juicyrecipes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Contents {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private RecipeUser recipeUser;
}
