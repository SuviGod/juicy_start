package we.juicy.juicyrecipes.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.repository.RecipeRepository;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RecipeService recipeService;

    private static final Integer USER_STATIC_ID = 1;

    @Override
    public Optional<RecipeUser> findById(Integer id){
        return userRepository.findById(id);
    }

    @Override
    public void saveProfile(RecipeUser user) {

    }
}
