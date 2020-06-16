package com.springframework.recipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.springframework.recipeApp.command.NotesCommand;
import com.springframework.recipeApp.model.Notes;


import lombok.Synchronized;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	  @Synchronized
	    @Nullable
	    @Override
	    public Notes convert(NotesCommand source) {
	        if(source == null) {
	            return null;
	        }

	        final Notes notes = new Notes();
	        notes.setId(source.getId());
	        notes.setRecipeNotes(source.getRecipeNotes());
	        return notes;
	    }
}
