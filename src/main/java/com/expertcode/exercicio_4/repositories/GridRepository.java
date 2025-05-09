package com.expertcode.exercicio_4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expertcode.exercicio_4.entities.Grid;

@Repository
public interface GridRepository extends JpaRepository<Grid, Long> {

}
