package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Ingredient;
import we.juicy.juicyrecipes.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAllIngredients (){
        return (List<Ingredient>) ingredientRepository.findAll();
    }
    @Override
    public Optional<Ingredient> findById(Integer id){
        return ingredientRepository.findById(id);
    }
}
