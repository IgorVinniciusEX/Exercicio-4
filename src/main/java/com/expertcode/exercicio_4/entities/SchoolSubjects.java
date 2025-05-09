package com.expertcode.exercicio_4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.dto.SchoolSubjectsDTO;
import com.expertcode.exercicio_4.util.Convertible;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_materia_escolar")
public class SchoolSubjects implements Serializable, Convertible<SchoolSubjectsDTO> {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToMany(mappedBy = "listSchoolSubjects")
	private List<Student> listStudent = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "listSchoolSubjects")
	private List<Grid> listGrids = new ArrayList<>();

	@OneToMany(mappedBy = "id.schoolSubjects")
	private List<StudentNote> listNotes = new ArrayList<>();

	public SchoolSubjects(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonIgnore
	public List<Grid> getListGrids() {
		return listGrids;
	}

	@Override
	public SchoolSubjectsDTO convert() {
		return new SchoolSubjectsDTO(this);
	}
}
