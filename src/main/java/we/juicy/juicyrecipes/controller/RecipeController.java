package we.juicy.juicyrecipes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor @Slf4j
public class RecipeController {

    @RequestMapping(value = "/cake", method = RequestMethod.GET)
    public String getRecipe(Model model) {
        log.info("requesting for apple cake");
        return "index.html";
    }
}
