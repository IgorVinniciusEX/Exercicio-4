package com.expertcode.exercicio_4.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class GridSubjectsPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grid grid;
	
	@ManyToOne
	@JoinColumn(name = "material_escolar_id")
	private SchoolSubjects schoolSubjects;

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public SchoolSubjects getSchoolSubjects() {
		return schoolSubjects;
	}

	public void setSchoolSubjects(SchoolSubjects schoolSubjects) {
		this.schoolSubjects = schoolSubjects;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grid, schoolSubjects);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridSubjectsPK other = (GridSubjectsPK) obj;
		return Objects.equals(grid, other.grid) && Objects.equals(schoolSubjects, other.schoolSubjects);
	}
}
