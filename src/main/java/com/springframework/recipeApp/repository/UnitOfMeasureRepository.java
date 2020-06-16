package com.springframework.recipeApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springframework.recipeApp.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

	
	Optional<UnitOfMeasure> findByUom(String uom);
}
