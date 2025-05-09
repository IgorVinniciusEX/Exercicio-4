package com.expertcode.exercicio_4.services;

import java.util.List;

import com.expertcode.exercicio_4.services.exceptions.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio_4.entities.Student;
import com.expertcode.exercicio_4.entities.dto.StudentDTO;
import com.expertcode.exercicio_4.repositories.StudentRepository;
import com.expertcode.exercicio_4.services.generics.ServiceGenerics;

@Service
@Transactional(readOnly = true)
public class StudentService implements ServiceGenerics<Student, StudentDTO, Long>{

	@Autowired
	StudentRepository repository;
	
	@Override
	public JpaRepository<Student, Long> getRepository() {
		return repository;
	}

	@Transactional
	public Student insert(StudentDTO obj) {
		if(obj.getGrid() == null) {
			throw new InvalidParameterException("Student must be enrolled in a school schedule! ");
		}
		Student entity = convertDTO(obj);
		
		return repository.save(entity);
	}
	
	@Transactional
	public List<Student> findByIdIn(List<Long> list){
		return repository.findByIdIn(list);
	}
	
	public Student convertDTO(StudentDTO dto) {
		return new Student(dto.getId(), dto.getName(), dto.getGrid());
	}
}
