package com.expertcode.exercicio_4.entities.dto;
import java.util.List;

import com.expertcode.exercicio_4.entities.Grid;

public class GridDTO {

	private Long id;
	private String name;
	
	private List<Long> listSchoolSubjects;
	
	public GridDTO() {
	}
	
	public GridDTO(Grid result) {
		this.id = result.getId();
		this.name = result.getName();
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

	public List<Long> getListSchoolSubjects() {
		return listSchoolSubjects;
	}

	public void setListSchoolSubjects(List<Long> listSchoolSubjects) {
		this.listSchoolSubjects = listSchoolSubjects;
	}	
}
