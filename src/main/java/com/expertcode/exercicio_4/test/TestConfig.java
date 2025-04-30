package com.expertcode.exercicio_4.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.expertcode.exercicio_4.entities.Grid;
import com.expertcode.exercicio_4.entities.SchoolSubjects;
import com.expertcode.exercicio_4.entities.Student;
import com.expertcode.exercicio_4.repositories.GridRepository;
import com.expertcode.exercicio_4.repositories.SchoolSubjectsRepository;
import com.expertcode.exercicio_4.repositories.StudentRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private SchoolSubjectsRepository schoolSubjectsRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private GridRepository gridRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SchoolSubjects sc1 =  new SchoolSubjects(null, "Matemática");
		SchoolSubjects sc2 =  new SchoolSubjects(null, "Ciências");
		SchoolSubjects sc3 =  new SchoolSubjects(null, "Biologia");
		SchoolSubjects sc4 =  new SchoolSubjects(null, "Física");
		SchoolSubjects sc5 =  new SchoolSubjects(null, "Português");
		SchoolSubjects sc6 =  new SchoolSubjects(null, "História");
		
		schoolSubjectsRepository.saveAll(Arrays.asList(sc1, sc2, sc3, sc4, sc5, sc6));
		
		Grid g1 = new Grid(null);
		Grid g2 = new Grid(null);
		
		g1.getListSchoolSubjects().addAll(Arrays.asList(sc1, sc2, sc3, sc4, sc5));
		g2.getListSchoolSubjects().addAll(Arrays.asList(sc1, sc2, sc3, sc4));
		
		gridRepository.saveAll(Arrays.asList(g1,g2));
		
		Student s1 = new Student(null, "Igor Vinnicius", g1);
		
		studentRepository.saveAll(Arrays.asList(s1));
	}
}
