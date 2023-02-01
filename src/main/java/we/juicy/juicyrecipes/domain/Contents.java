package we.juicy.juicyrecipes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Contents {
    @Id
    private Integer id;

    @ManyToOne
    private Ingredient ingredient;

    private Integer amount;
}
