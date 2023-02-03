package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.repository.IngredientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j @RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAllIngredients (){
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Set<Ingredient> findAll() {
        Set<Ingredient> ingredients = new HashSet<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredientToUpdate) {
        return ingredientRepository.save(ingredientToUpdate);
    }

    @Override
    public Optional<Ingredient> findById(Integer id){
        return ingredientRepository.findById(id);
    }
}
