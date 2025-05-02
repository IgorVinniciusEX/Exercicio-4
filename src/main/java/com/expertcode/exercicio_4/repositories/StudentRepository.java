package com.expertcode.exercicio_4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expertcode.exercicio_4.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("""
			SELECT s FROM Student s
			WHERE s.id in :list
			""")
	List<Student> findByIdIn(List<Long> list);
}
