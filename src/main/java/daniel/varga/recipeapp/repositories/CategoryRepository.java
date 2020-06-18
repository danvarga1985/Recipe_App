package daniel.varga.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import daniel.varga.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
