package com.expertcode.exercicio_4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.exceptions.InvalidQuantityException;
import com.expertcode.exercicio_4.repositories.GridRepository;

@Service
@Transactional(readOnly = true)
public class GridService {

	@Autowired
	private GridRepository repository;
	
	@Autowired
	private SchoolSubjectsService subjectsService;
	
	public List<Grid> findAll() {
		return repository.findAll();
	}

	public Grid findById(Long id) {
		Optional<Grid> obj = repository.findById(id);
		return obj.get();
	}

	@Transactional
	public Grid insert(GridDTO obj) {
		List<SchoolSubjects> list = subjectsService.findByIdIn(obj.getListSchoolSubjects());
		if(list == null || list.size() < 5) {
			throw new InvalidQuantityException(list.size());
		} 
		Grid grid = convertDTO(obj);
		grid.setListSchoolSubjects(list);
		
		return repository.save(grid);
	}
	
	public Grid convertDTO(GridDTO dto) { 
		return new Grid(dto.getId(), dto.getName());
	}
}
