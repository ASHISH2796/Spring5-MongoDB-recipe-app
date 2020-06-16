package com.springframework.recipeApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.recipeApp.command.IngredientCommand;
import com.springframework.recipeApp.command.UnitOfMeasureCommand;
import com.springframework.recipeApp.service.IngredientService;
import com.springframework.recipeApp.service.RecipeService;
import com.springframework.recipeApp.service.UnitOfMeasureService;

@Controller
public class IngredientController {
 
	private final RecipeService recipeService;
	private final IngredientService ingredientService;
	private final UnitOfMeasureService unitOfMeasureService;
	
	public IngredientController(RecipeService recipeService, IngredientService ingredientService,
			UnitOfMeasureService unitOfMeasureService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
		this.unitOfMeasureService = unitOfMeasureService;
	}

	@GetMapping
	@RequestMapping("recipe/{id}/ingredients")
	public String showIngredient(@PathVariable String id ,Model model) {
		model.addAttribute("recipe",recipeService.findByCommandID(id));
		return "recipe/ingredient/list";
	}
	
	@GetMapping
	@RequestMapping("recipe/{recipeId}/ingredients/{ingredientId}/show")
	public String showIngredientById(@PathVariable String recipeId , @PathVariable String ingredientId,Model model) {
		model.addAttribute("ingredient",ingredientService.findIngredientByRecipeIdandIngredientId(recipeId, ingredientId));
		return "recipe/ingredient/show";
	}
	
	
	@GetMapping
	@RequestMapping("recipe/{recipeId}/ingredients/{ingredientId}/update")
	public String updateIngredientById(@PathVariable String recipeId , @PathVariable String ingredientId,Model model) {
		model.addAttribute("ingredient",ingredientService.findIngredientByRecipeIdandIngredientId(recipeId, ingredientId));
		model.addAttribute("uomList",unitOfMeasureService.findAll());
		return "recipe/ingredient/ingredientForm";
	}
	
	@PostMapping
	@RequestMapping("recipe/{id}/ingredient")
	public String SaveOrUpdateIngredient(@ModelAttribute IngredientCommand command,@PathVariable String id) {
		command.setRecipeId(id);
		System.out.println(command.getUnitOfMeasure());
		IngredientCommand savedCommand =ingredientService.saveCommand(command);
		return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
	}
	
}
