package com.springframework.recipeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.recipeApp.command.RecipeCommand;
import com.springframework.recipeApp.service.RecipeServiceImpl;

@Controller
public class RecipeController {

	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	@GetMapping
	@RequestMapping("/recipe/{id}/show")
	public String showRecipeDetail(@PathVariable long id, Model model ) {
		model.addAttribute("recipeDetail",recipeServiceImpl.findById(id));
		return  "recipe/show";
	}
	@GetMapping
	@RequestMapping("/recipe/new")
	public String newRecipe(Model model)
	{
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeForm";
	}
	@GetMapping
	@RequestMapping("/recipe/{id}/update")
	public String showRecipeDetailForUpdate(@PathVariable long id,Model model) {
	 model.addAttribute("recipe",recipeServiceImpl.findByCommandID(id));	
	return "recipe/recipeForm";	
	}
	
	@PostMapping
	@RequestMapping("recipe")
	public String saveOrupdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
		RecipeCommand recipeCmd=recipeServiceImpl.saveCommand(recipeCommand);
		return "redirect:/recipe/"+recipeCmd.getId()+"/show";
	}
	
	@GetMapping
	@RequestMapping("recipe/{id}/delete")
	public String deleteRecipeDetail(@PathVariable long id) {
		recipeServiceImpl.deleteById(id);
		return "redirect:/";
	}
}
