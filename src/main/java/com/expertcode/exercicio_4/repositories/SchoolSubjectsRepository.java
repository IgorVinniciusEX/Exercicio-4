package com.expertcode.exercicio_4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expertcode.exercicio_4.entities.SchoolSubjects;

@Repository
public interface SchoolSubjectsRepository extends JpaRepository<SchoolSubjects, Long>{

	@Query("""
			SELECT s from SchoolSubjects s
			WHERE s.id in :list
			""")
	List<SchoolSubjects> findByIdIn(List<Long> list);
}
