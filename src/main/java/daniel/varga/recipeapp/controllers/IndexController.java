package daniel.varga.recipeapp.controllers;

import daniel.varga.recipeapp.domain.Category;
import daniel.varga.recipeapp.domain.UnitOfMeasure;
import daniel.varga.recipeapp.repositories.CategoryRepository;
import daniel.varga.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        //TODO create model & refer to index html

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println("Cat id is: " + optionalCategory.get().getId());
        System.out.println("UOM id is: " + optionalUnitOfMeasure.get().getId());

        return "index";
    }
}
