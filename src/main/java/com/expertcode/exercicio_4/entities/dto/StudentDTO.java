package com.expertcode.exercicio_4.entities.dto;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
	
	private Long id;
	private String name;
	private Grid grid;
	
	public StudentDTO(Student entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.grid = entity.getGrid();
	}
}
