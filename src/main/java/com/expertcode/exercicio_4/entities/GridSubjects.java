package com.expertcode.exercicio_4.entities;

import java.io.Serializable;
import java.util.Objects;

import com.expertcode.exercicio_4.entities.pk.GridSubjectsPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_grade_materias")
public class GridSubjects implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private GridSubjectsPK id = new GridSubjectsPK();
	
	public GridSubjects() {
		
	}
	
	public GridSubjects(Grid grid, SchoolSubjects schoolSubjects) {
		id.setGrid(grid);
		id.setSchoolSubjects(schoolSubjects);
	}

	public Grid getGrid() {
		return id.getGrid();
	}
	
	public void setGrid(Grid grid) {
		id.setGrid(grid);
	}
	
	public SchoolSubjects getSchoolSubjects() {
		return id.getSchoolSubjects();
	}
	
	public void setSchoolSubjects(SchoolSubjects schoolSubjects) {
		id.setSchoolSubjects(schoolSubjects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridSubjects other = (GridSubjects) obj;
		return Objects.equals(id, other.id);
	}
}
