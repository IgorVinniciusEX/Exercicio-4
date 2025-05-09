package com.expertcode.exercicio_4.entities;

import com.expertcode.exercicio_4.entities.chavesPrimarias.StudentNotePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_nota_estudante")
public class StudentNote implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private StudentNotePK id = new StudentNotePK();

    private Double note;

    public StudentNote(Student student, SchoolSubjects schoolSubjects, Double note) {
        id.setStudent(student);
        id.setSchoolSubjects(schoolSubjects);
        this.note = note;
    }
}
