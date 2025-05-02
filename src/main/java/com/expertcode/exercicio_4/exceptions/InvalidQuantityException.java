package com.expertcode.exercicio_4.exceptions;

public class InvalidQuantityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException(Integer size) {
		super("Invalid quantity exception: " + size);
	}

}
