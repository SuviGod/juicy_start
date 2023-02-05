package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.domain.RecipeUser;
import we.juicy.juicyrecipes.service.IngredientService;
import we.juicy.juicyrecipes.service.SingleUserService;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final SingleUserService userService;
    private final IngredientService ingredientService;

    @GetMapping()
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

    @GetMapping("/{userId}/ingredients/new")
    public String addNewIngredient(@PathVariable("userId") Integer userId, Model model ){
        model.addAttribute("ingredients", ingredientService.findAll());
        Optional<RecipeUser> maybeRecipeUser = userService.findById(userId);
        if (maybeRecipeUser.isEmpty())
            return "error";

        model.addAttribute("content", new Contents());
        model.addAttribute("user", maybeRecipeUser.get());
        return "/user/ingredient_contents_form";
    }
    @PostMapping("/{userId}/ingredients/new")
    public String saveAddingNewIngredient(@ModelAttribute Contents contents , @PathVariable("userId") Integer userId){
        log.info("Saving ingredient contents for user -> {}, id -> {}", contents, userId);
        userService.addIngredient(userId, contents);
        log.info ("After saving");

        return "redirect:/me/" + userId + "/show";
    }
    @GetMapping("{id}/show")
    public String getById(@PathVariable("id") Integer userId, Model model){
        Optional<RecipeUser> maybeRecipe = userService.findById(userId);
        if (maybeRecipe.isPresent()) {
            RecipeUser user = maybeRecipe.get();
            model.addAttribute("user", user);
            return "user/profile";
        }
        return "error";
    }
}
