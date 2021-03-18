package br.com.maria.eduarda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maria.eduarda.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
