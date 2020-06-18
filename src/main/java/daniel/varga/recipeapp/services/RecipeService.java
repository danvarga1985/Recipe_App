package daniel.varga.recipeapp.services;

import daniel.varga.recipeapp.domain.Recipe;
import daniel.varga.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();

}
