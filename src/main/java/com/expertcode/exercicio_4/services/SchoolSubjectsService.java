package com.expertcode.exercicio_4.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.repositories.SchoolSubjectsRepository;

@Service
public class SchoolSubjectsService{
	
	@Autowired
	SchoolSubjectsRepository repository;
	
	public List<SchoolSubjects> findAll(){
		return repository.findAll();
	}

	public SchoolSubjects findById(Long id) {
		Optional<SchoolSubjects> obj = repository.findById(id);
		return obj.get();
	}
	
	public SchoolSubjects insert(SchoolSubjects obj) {
		return repository.save(obj);
	}
}
