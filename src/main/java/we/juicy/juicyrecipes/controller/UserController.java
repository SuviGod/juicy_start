package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.service.SingleUserService;
import we.juicy.juicyrecipes.service.UserService;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final SingleUserService userService;

    @GetMapping
    public String getUser(Model model) {
        try {
            RecipeUser currentUser = userService.getCurrentUser();
            log.info("User is -> {}", currentUser);
            model.addAttribute("user", currentUser);
        } catch (RuntimeException ex) {
            log.info("User is not found. Trying to create new.");
            return "redirect:/me/register";
        }

        return "/user/profile";
    }

    @GetMapping("/register")
    public String tryCreatingUser(Model model) {
        log.info("Trying to create new user");
        model.addAttribute("user", new RecipeUser());
        return "user/registration";
    }

    @PostMapping("/register")
    public String saveProfile(@ModelAttribute("user") RecipeUser user) {
        log.info("Saving user -> {}", user);
        userService.saveUser(user);
        return "redirect:/me";
    }
}
