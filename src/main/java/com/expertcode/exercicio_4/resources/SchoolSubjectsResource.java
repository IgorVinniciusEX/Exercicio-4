package com.expertcode.exercicio_4.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.services.SchoolSubjectsService;

@RestController
@RequestMapping(value = "/school_subjects")
public class SchoolSubjectsResource {

	@Autowired
	private SchoolSubjectsService service;
	
	@GetMapping
	public ResponseEntity<List<SchoolSubjects>> findAll(){
		List<SchoolSubjects> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SchoolSubjects> findById(@PathVariable Long id){
		SchoolSubjects obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<SchoolSubjects> insert(@RequestBody SchoolSubjects obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
