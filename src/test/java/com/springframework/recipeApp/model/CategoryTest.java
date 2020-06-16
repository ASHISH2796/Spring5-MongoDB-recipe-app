package com.springframework.recipeApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {
   Category category;
   
   @Before
   public void setup() {
	   category =new Category();
   }
	
	@Test
	public void getId() throws Exception {
	   Long idvalue =4L;
	  category.setId(idvalue);
	   assertEquals(idvalue, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception {
		
	}
	
	@Test
	public void getRecipe() throws Exception {
	
	}
}
