package com.springframework.recipeApp.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.springframework.recipeApp.command.UnitOfMeasureCommand;
import com.springframework.recipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.springframework.recipeApp.repository.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final UnitOfMeasureToUnitOfMeasureCommand command;
	
	public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
			UnitOfMeasureToUnitOfMeasureCommand command) {
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.command = command;
	}

	@Override
	public Set<UnitOfMeasureCommand> findAll() {
		return StreamSupport.stream(unitOfMeasureRepository.findAll()
				.spliterator() , false)
				.map(command::convert)
				.collect(Collectors.toSet());
	}

}
