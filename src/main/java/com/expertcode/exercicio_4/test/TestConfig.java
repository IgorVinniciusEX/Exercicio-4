package com.expertcode.exercicio_4.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.expertcode.exercicio_4.repositories.SchoolSubjectsRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private SchoolSubjectsRepository schoolSubjectsRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
