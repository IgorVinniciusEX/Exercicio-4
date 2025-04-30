package com.expertcode.exercicio_4.exceptions;

import com.expertcode.exercicio_4.entities.Grid;

public class InvalidQuantityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException(Grid obj) {
		super("Invalid quantity exception: " + obj.getListSchoolSubjects().size());
	}

}
