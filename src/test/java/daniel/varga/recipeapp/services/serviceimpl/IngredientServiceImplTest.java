package daniel.varga.recipeapp.services.serviceimpl;

import daniel.varga.recipeapp.commands.IngredientCommand;
import daniel.varga.recipeapp.converters.IngredientToIngredientCommand;
import daniel.varga.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import daniel.varga.recipeapp.domain.Ingredient;
import daniel.varga.recipeapp.domain.Recipe;
import daniel.varga.recipeapp.repositories.RecipeRepository;
import daniel.varga.recipeapp.services.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;

    //init converters
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand =
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
    }

    @Test
    void findByRecipeIdAndIngredientId()  throws Exception {
    }

    @Test
    void findByRecipeIdAndIngredientIdHappyPath() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        //when
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //then
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }
}