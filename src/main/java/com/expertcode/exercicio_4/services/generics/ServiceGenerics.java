package com.expertcode.exercicio_4.services.generics;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.expertcode.exercicio_4.util.Convertible;

public interface ServiceGenerics<T extends Convertible<DTO>, DTO, ID> {
	
	@Autowired
	JpaRepository<T, ID> getRepository();
	
	@Transactional
	default List<DTO> findAll(){
		List<T> list = getRepository().findAll();
		return list.stream().map(Convertible::convert).collect(Collectors.toList());
	}
	
	@Transactional
	default DTO findById(ID id) {
		Optional<T> obj = getRepository().findById(id);
		return obj.orElseThrow().convert(); //criar exceção
	}
	
	@Transactional
	default void delete(ID id) {
		getRepository().deleteById(id);
	}
	
	@Transactional
	default T insert(T obj) {
		return getRepository().save(obj);
	}
	

}
