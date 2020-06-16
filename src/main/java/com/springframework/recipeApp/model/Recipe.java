package com.springframework.recipeApp.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving ;
	private String source;
	private String url;
	@Lob
	private String direction;
	
	@Enumerated(value=EnumType.STRING)
	private Difficulty difficulty;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient>  ingredient=new HashSet<>(); 

	@Lob
	private Byte[] image;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Notes notes;

	@ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> category = new HashSet<>();
	
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServing() {
		return serving;
	}
	public void setServing(Integer serving) {
		this.serving = serving;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Notes getNotes() {
		return notes;
	}*/
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
	/*public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Set<Ingredient> getIngredient() {
		return ingredient;
	}
	public void setIngredient(Set<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}
	public Set<Category> getCategories() {
		return category;
	}
	public void setCategories(Set<Category> category) {
		this.category = category;
	}
	*/
	public void addIngredient(Ingredient ingredient2) {
	  ingredient.add(ingredient2);
		
	}
	/*@Override
	public String toString() {
		return "Recipe [id=" + id + ", description=" + description + ", prepTime=" + prepTime + ", cookTime=" + cookTime
				+ ", serving=" + serving + ", source=" + source + ", url=" + url + ", direction=" + direction
				+ ", difficulty=" + difficulty + ", ingredient=" + ingredient + ", image=" + Arrays.toString(image)
				+ ", notes=" + notes + ", category=" + category + "]";
	}*/
	
	
}
