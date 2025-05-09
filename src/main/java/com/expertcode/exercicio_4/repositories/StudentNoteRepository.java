package com.expertcode.exercicio_4.repositories;

import com.expertcode.exercicio_4.entities.StudentNote;
import com.expertcode.exercicio_4.entities.chavesPrimarias.StudentNotePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentNoteRepository extends JpaRepository<StudentNote, StudentNotePK> {
}
