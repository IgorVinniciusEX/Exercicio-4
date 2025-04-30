package com.expertcode.exercicio_4.entities.dto;

import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;

public class GridDTO {

	private Long id;
	
	private List<SchoolSubjects> list = new ArrayList<>();
	
	public GridDTO() {
	}
	
	public GridDTO(Grid result) {
		result.getId();
	}
	
}
