package com.expertcode.exercicio_4.entities.dto;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GridDTO {

	private Long id;
	private String name;
	
	private List<Long> listSchoolSubjects = new ArrayList<>();
	
	private List<SchoolSubjects> schoolSubjects = new ArrayList<>();
	
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

	@JsonIgnore
	public List<Long> getListSchoolSubjects() {
		return listSchoolSubjects;
	}

	public List<SchoolSubjects> getSchoolSubjects() {
		return schoolSubjects;
	}
}
