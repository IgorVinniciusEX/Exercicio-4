package com.expertcode.exercicio_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio4Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio4Application.class, args);
	}

}

/*EXERCÍCIO 4

Crie uma aplicação Java com Spring.

Implemente um serviço que cadastre matérias escolares. Elas precisam ter nome. > ok - ok

Implemente um serviço que cadastre alunos. Eles precisam ter nome. > ok - ok

Implemente um serviço que cadastre uma grade escolar. > ok - teste 

Uma grade deverá possuir no mínimo 5 matérias > ok - teste 
e sempre deverá estar relacionada a algum aluno. > ok -  teste

Um aluno somente poderá ter uma grade de matéria. > ok - teste

Implementar um serviço que exiba um histórico de todos os alunos com filtro por aluno opcional.

Implementar um serviço que exiba os melhores alunos por score.

Os alunos para concluir uma matéria deverão tirar 3 notas consecutivas maiores que 80%.

Caso ele não atinja essa meta, ele voltará ao início da contagem.

Depois de concluir uma matéria ele não poderá receber mais lançamentos de notas naquela matéria e deverá passar para a próxima matéria de sua grade.

Deve ser entregue a aplicação com testes de integração realizados e o diagrama do modelo de dados gerado.

Como requisitos não funcionais, utilizar banco de dados Mysql.

*/