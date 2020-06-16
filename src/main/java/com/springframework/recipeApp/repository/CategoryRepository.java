package com.springframework.recipeApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springframework.recipeApp.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
