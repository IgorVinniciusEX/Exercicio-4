package com.expertcode.exercicio_4.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.util.Convertible;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_grade_escolar")
public class Grid implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(mappedBy = "grid")
	private List<Student> listStudents = new ArrayList<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "grade_com_materias",
			joinColumns = @JoinColumn(name = "grid_id"),
			inverseJoinColumns = @JoinColumn(name = "schoolSubjects_id"))
	private List<SchoolSubjects> listSchoolSubjects = new ArrayList<>();

	public Grid(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonIgnore
	public List<Student> getListStudents() {
		return listStudents;
	}

}
