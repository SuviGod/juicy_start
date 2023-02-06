package we.juicy.juicyrecipes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Lob
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    private List<Contents> necessaryAmount = new ArrayList<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
//    private Set<Contents> necessaryAmount = new HashSet<>();

    public void addContents(Contents contents) {
        necessaryAmount.add(contents);
        contents.setRecipe(this);
    }
    @Override
    public String toString(){
        return "RecipeUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", necessaryAmount=" + necessaryAmount +
                '}';
    }

}
