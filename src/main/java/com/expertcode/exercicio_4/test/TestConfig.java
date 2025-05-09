package com.expertcode.exercicio_4.test;

import java.util.Arrays;

import com.expertcode.exercicio_4.entities.StudentNote;
import com.expertcode.exercicio_4.repositories.StudentNoteRepository;
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

	@Autowired
	private StudentNoteRepository studentNoteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SchoolSubjects sc1 =  new SchoolSubjects(null, "Matemática");
		SchoolSubjects sc2 =  new SchoolSubjects(null, "Ciências");
		SchoolSubjects sc3 =  new SchoolSubjects(null, "Biologia");
		SchoolSubjects sc4 =  new SchoolSubjects(null, "Física");
		SchoolSubjects sc5 =  new SchoolSubjects(null, "Português");
		SchoolSubjects sc6 =  new SchoolSubjects(null, "História");
		
		schoolSubjectsRepository.saveAll(Arrays.asList(sc1, sc2, sc3, sc4, sc5, sc6));
		
		Grid g1 = new Grid(null, "Grade 1");
		Grid g2 = new Grid(null, "Grade 2");
		
		g1.getListSchoolSubjects().addAll(Arrays.asList(sc1, sc2, sc3, sc4, sc5));
		g2.getListSchoolSubjects().addAll(Arrays.asList(sc1, sc2, sc3, sc4, sc5, sc6));
		
		gridRepository.saveAll(Arrays.asList(g1, g2));
		
		Student s1 = new Student(null, "Igor Vinnicius", g1);
		Student s2 = new Student(null, "Maria Aparecida", null);
		
		studentRepository.saveAll(Arrays.asList(s1, s2));

		StudentNote sn1 = new StudentNote(s1, sc1, 30.0);
		StudentNote sn2 = new StudentNote(s1, sc2, 60.0);

		studentNoteRepository.saveAll(Arrays.asList(sn1, sn2));
	}
}
