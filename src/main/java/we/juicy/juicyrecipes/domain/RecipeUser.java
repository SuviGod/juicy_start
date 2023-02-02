package we.juicy.juicyrecipes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class RecipeUser {
    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "recipeUser")
    private List<Contents> amountPresent;
}
