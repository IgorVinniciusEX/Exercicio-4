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
	
	/*public GridDTO(Grid result) {
		this.id = result.getId();
		this.list = result.getListSchoolSubjects();
	}*/
	
	public GridDTO(Grid result) {
		if(result.getListSchoolSubjects() != null) {
			result.getListSchoolSubjects().forEach(x -> this.list.add(new SchoolSubjects()));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SchoolSubjects> getList() {
		return list;
	}
}
