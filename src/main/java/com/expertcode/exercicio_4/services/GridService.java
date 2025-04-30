package com.expertcode.exercicio_4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.exceptions.InvalidQuantityException;
import com.expertcode.exercicio_4.repositories.GridRepository;

@Service
public class GridService {

	@Autowired
	GridRepository repository;

	public List<Grid> findAll() {
		return repository.findAll();
	}

	public Grid findById(Long id) {
		Optional<Grid> obj = repository.findById(id);
		return obj.get();
	}

	public Grid insert(Grid obj) {
		if(obj.getListSchoolSubjects() == null || obj.getListSchoolSubjects().size() < 5) {
			throw new InvalidQuantityException(obj);
		}
		return repository.save(obj);
	}
}
