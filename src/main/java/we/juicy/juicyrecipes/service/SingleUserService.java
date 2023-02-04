package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SingleUserService {

    private static final Integer SINGLE_USER_ID = 1;
    private final UserRepository userRepository;

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
}
