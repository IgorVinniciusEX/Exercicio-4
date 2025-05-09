package com.expertcode.exercicio_4.services;

import java.util.List;
import java.util.Optional;

import com.expertcode.exercicio_4.entities.mapper.GridMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.repositories.GridRepository;
import com.expertcode.exercicio_4.services.exceptions.InvalidQuantityException;

@Service
@Transactional(readOnly = true)
public class GridService {

	@Autowired
	private GridRepository repository;
	
	@Autowired
	private SchoolSubjectsService subjectsService;

	@Autowired
	private GridMapper mapper;
	
	/*@Transactional
	public List<GridDTO> findAll() {	
		List<Grid> entity = repository.findAll();
		return entity.stream().map(x -> new GridDTO(x)).toList();
	}*/

	@Transactional
	public GridDTO findById(Long id) {
		Grid obj = repository.findById(id).get();
		return mapper.toGridDTO(obj);
	}

	@Transactional
	public Grid insert(GridDTO obj) {
		List<SchoolSubjects> listSubject = subjectsService.findByIdIn(obj.getListSchoolSubjects());
		if(listSubject == null || listSubject.size() < 5) {
			throw new InvalidQuantityException("SchoolSubjects",listSubject.size());
		} 
		
		Grid grid = convertDTO(obj);
		grid.setListSchoolSubjects(listSubject);
		
		return repository.save(grid);
	}
	
	public Grid convertDTO(GridDTO dto) { 
		return new Grid(dto.getId(), dto.getName());
	}
}
