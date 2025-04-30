package com.expertcode.exercicio_4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

@Entity
@Table(name = "tb_grade_escolar")
public class Grid implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "grid")
	private List<Student> listStudents = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "grade_com_materias",
			joinColumns = @JoinColumn(name = "grid_id"),
			inverseJoinColumns = @JoinColumn(name = "schoolSubjects_id"))
	private List<SchoolSubjects> listSchoolSubjects = new ArrayList<>();
	
	public Grid() {
		
	}
	
	public Grid(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@JsonIgnore
	public List<Student> getListStudents() {
		return listStudents;
	}

	public void setListSchoolSubjects(List<SchoolSubjects> listSchoolSubjects) {
		this.listSchoolSubjects = listSchoolSubjects;
	}

	public List<SchoolSubjects> getListSchoolSubjects() {
		return listSchoolSubjects;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		return Objects.equals(id, other.id);
	}
}
