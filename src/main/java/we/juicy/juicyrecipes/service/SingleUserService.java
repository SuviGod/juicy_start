package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.repository.ContentsRepository;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SingleUserService {

    private static final Integer SINGLE_USER_ID = 1;
    private final UserRepository userRepository;
    private final ContentsRepository contentsRepository;

    public RecipeUser getCurrentUser() {
        Optional<RecipeUser> maybeSingleUser = userRepository.findById(1);
        if (maybeSingleUser.isEmpty())
            throw new RuntimeException("User is not found");

        return maybeSingleUser.get();
    }

    public RecipeUser saveUser(RecipeUser user) {
        user.setId(SINGLE_USER_ID);
        return userRepository.save(user);
    }
    public Optional<RecipeUser> findById(Integer id){
        return userRepository.findById(id);
    }

    @Transactional
    public RecipeUser addIngredient(Integer id, Contents contents){
        Optional<RecipeUser> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty())
            throw new RuntimeException("User with id is not found");

        RecipeUser user = maybeUser.get();
        contents.setRecipeUser(user);

        Contents savedContents = contentsRepository.save(contents);
        user.addContents(savedContents);
        return userRepository.save(user);
    }


}
