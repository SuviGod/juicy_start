package we.juicy.juicyrecipes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private RecipeUser recipeUser;

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", recipe=" + recipe +
                ", recipeUser=" + recipeUser.getName() +
                '}';
    }


}
