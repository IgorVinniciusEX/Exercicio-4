package com.expertcode.exercicio_4.entities.dto;
import com.expertcode.exercicio_4.entities.SchoolSubjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectsDTO {

	private Long id;
	private String name;

	public SchoolSubjectsDTO(SchoolSubjects entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
}
