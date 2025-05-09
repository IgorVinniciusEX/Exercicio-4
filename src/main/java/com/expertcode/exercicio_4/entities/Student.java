package com.expertcode.exercicio_4.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio_4.entities.dto.StudentDTO;
import com.expertcode.exercicio_4.util.Convertible;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Student implements Serializable, Convertible<StudentDTO>{

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "grid_id")
	private Grid grid;

	@OneToMany(mappedBy = "id.student")
	private List<StudentNote> listNotes = new ArrayList<>();
	
	public Student(Long id, String name, Grid grid) {
		this.id = id;
		this.name = name;
		this.grid = grid;
	}

    @Override
	public StudentDTO convert() {
		return new StudentDTO(this);
	}

}
