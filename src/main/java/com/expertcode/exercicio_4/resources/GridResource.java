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

import com.expertcode.exercicio_4.entities.dto.GridDTO;
import com.expertcode.exercicio_4.services.GridService;

@RestController
@RequestMapping(value = "/grids")
public class GridResource {

	@Autowired
	private GridService service;
	
	@GetMapping
	public ResponseEntity<List<GridDTO>> findAll(){
		List<GridDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GridDTO> findById(@PathVariable Long id){
		GridDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@PostMapping
	public ResponseEntity<Void> insert(@RequestBody GridDTO dto){
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
}
