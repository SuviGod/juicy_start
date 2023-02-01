package we.juicy.juicyrecipes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String name;

    @OneToMany
    private List<Contents> amountPresent;
}
