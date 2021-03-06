package com.bogdan.repo;

import com.bogdan.model.Recipe;
import com.bogdan.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Recipe getRecipeById(Long id);

    void deleteById(int id);

    List<Recipe> findAllByOrderByIdAsc();

    List<Recipe> findByName(String name);

    List<Recipe> findByAuthor(User user);
}
