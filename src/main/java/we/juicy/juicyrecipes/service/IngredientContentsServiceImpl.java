package we.juicy.juicyrecipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.juicy.juicyrecipes.domain.Contents;
import we.juicy.juicyrecipes.repository.ContentsRepository;

@Service
@RequiredArgsConstructor
public class IngredientContentsServiceImpl implements IngredientContentsService {

    private final ContentsRepository contentsRepository;

    @Override
    public void addForRecipe(Contents contents) {

    }

    @Override
    public void addForUser(Contents contents) {

    }
}
