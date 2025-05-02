package com.expertcode.exercicio_4.entities.dto;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.Student;

public class StudentDTO {
	
	private Long id;
	private String name;
	private Grid grid;
	
	public StudentDTO() {
	}
	
	public StudentDTO(Student entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.grid = entity.getGrid();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
}
