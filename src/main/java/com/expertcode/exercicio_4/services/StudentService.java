package com.expertcode.exercicio_4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertcode.exercicio_4.entities.Student;
import com.expertcode.exercicio_4.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<Student> findAll() {
		return repository.findAll();
	}

	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.get();
	}

	public Student insert(Student obj) {
		return repository.save(obj);
	}
}
