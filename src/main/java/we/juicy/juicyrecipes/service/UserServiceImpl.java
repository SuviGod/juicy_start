package we.juicy.juicyrecipes.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.repository.UserRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Optional<RecipeUser> findById(Integer id){
        return userRepository.findById(id);
    }
}
