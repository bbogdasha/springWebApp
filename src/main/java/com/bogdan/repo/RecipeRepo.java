package com.bogdan.repo;

import com.bogdan.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Recipe getRecipeById(int id);

    void deleteById(int id);

    List<Recipe> findAllByOrderByIdAsc();

    List<Recipe> findByName(String name);
}
