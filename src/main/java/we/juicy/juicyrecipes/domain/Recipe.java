package we.juicy.juicyrecipes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    private Integer id;

    private String name;
    @Lob
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany
    private List<Contents> necessaryAmount;
}
