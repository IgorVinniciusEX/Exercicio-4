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

}
