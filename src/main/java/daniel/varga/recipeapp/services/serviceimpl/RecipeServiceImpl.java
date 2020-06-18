package daniel.varga.recipeapp.services.serviceimpl;

import daniel.varga.recipeapp.domain.Recipe;
import daniel.varga.recipeapp.repositories.RecipeRepository;
import daniel.varga.recipeapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipes :: add);

        return recipes;
    }
}
