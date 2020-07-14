package daniel.varga.recipeapp.services;

import daniel.varga.recipeapp.commands.RecipeCommand;
import daniel.varga.recipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);

}
