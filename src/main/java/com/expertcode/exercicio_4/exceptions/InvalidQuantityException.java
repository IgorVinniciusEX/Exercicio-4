package com.expertcode.exercicio_4.exceptions;

import com.expertcode.exercicio_4.entities.dto.GridDTO;

public class InvalidQuantityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException(GridDTO obj) {
		super("Invalid quantity exception: " + obj.getList().size());
	}

}
