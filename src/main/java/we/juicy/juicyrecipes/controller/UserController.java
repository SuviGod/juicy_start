package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import we.juicy.juicyrecipes.domain.Recipe;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.service.UserService;
import we.juicy.juicyrecipes.service.UserServiceImpl;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String getUserProfilePage(@PathVariable("id") Integer id, Model model){
        log.info("Requesting for profile user with id -> {}", id);
        Optional<RecipeUser> maybeUser = userService.findById(id);
        if (maybeUser.isPresent()) {
            RecipeUser user = maybeUser.get();
            model.addAttribute("user", user);
            return "user/profile";
        }

        return "error";
    }
}
