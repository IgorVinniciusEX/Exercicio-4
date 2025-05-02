package com.expertcode.exercicio_4.entities.dto;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GridDTO {

	private Long id;
	private String name;
	
	private List<Long> listSchoolSubjects = new ArrayList<>();
	
	private List<SchoolSubjects> schoolSubjects = new ArrayList<>();
	
	public GridDTO() {
	}
	
	public GridDTO(Grid result) {
		this.id = result.getId();
		this.name = result.getName();
		
		if(listSchoolSubjects != null) {
			for(SchoolSubjects s : result.getListSchoolSubjects()) {
				this.listSchoolSubjects.add(s.getId());
				this.schoolSubjects.add(s);
			}
		}
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

	@JsonIgnore
	public List<Long> getListSchoolSubjects() {
		return listSchoolSubjects;
	}

	public void setListSchoolSubjects(List<Long> listSchoolSubjects) {
		this.listSchoolSubjects = listSchoolSubjects;
	}

	public List<SchoolSubjects> getSchoolSubjects() {
		return schoolSubjects;
	}

	public void setSchoolSubjects(List<SchoolSubjects> schoolSubjects) {
		this.schoolSubjects = schoolSubjects;
	}
}
