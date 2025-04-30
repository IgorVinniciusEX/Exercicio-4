package com.expertcode.exercicio_4.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.exceptions.InvalidQuantityException;
import com.expertcode.exercicio_4.repositories.GridRepository;
import com.expertcode.exercicio_4.repositories.SchoolSubjectsRepository;

@Service
public class GridService {

	@Autowired
	GridRepository repository;
	
	@Autowired
    private SchoolSubjectsRepository subjectRepository;

	public List<Grid> findAll() {
		return repository.findAll();
	}

	public Grid findById(Long id) {
		Optional<Grid> obj = repository.findById(id);
		return obj.get();
	}

	public GridDTO insert(GridDTO obj) {
		if(obj.getList() == null || obj.getList().size() < 5) {
			throw new InvalidQuantityException(obj);
		} 
		Grid entity = new Grid();
		entity.setId(obj.getId());
		
		List<SchoolSubjects> subjectList = obj.getList().stream()
	            .map(sub -> subjectRepository.findById(sub.getId())
	                    .orElseThrow(() -> new RuntimeException("Subject not found: id=" + sub.getId())))
	            .collect(Collectors.toList());

	        entity.setListSchoolSubjects(subjectList);

		
		Grid saved = repository.save(entity);
		
		return new GridDTO(saved);
	}
}
