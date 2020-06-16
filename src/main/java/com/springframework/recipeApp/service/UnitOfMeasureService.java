package com.springframework.recipeApp.service;

import java.util.Set;

import com.springframework.recipeApp.command.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	public Set<UnitOfMeasureCommand> findAll();
}
