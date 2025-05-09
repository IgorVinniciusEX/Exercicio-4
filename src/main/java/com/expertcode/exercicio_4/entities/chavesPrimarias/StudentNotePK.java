package com.expertcode.exercicio_4.entities.chavesPrimarias;

import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.Student;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class StudentNotePK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Student student;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private SchoolSubjects schoolSubjects;
}
