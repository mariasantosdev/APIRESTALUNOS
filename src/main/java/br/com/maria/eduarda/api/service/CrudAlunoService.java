package br.com.maria.eduarda.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.maria.eduarda.api.model.Aluno;
import br.com.maria.eduarda.api.repository.AlunoRepository;

@Service
public class CrudAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}	
	
	
	public ResponseEntity<Aluno> RecuperaAlunosPorId(Long alunoId) {
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
		
	public void excluir(Long alunoId) {
		alunoRepository.deleteById(alunoId);
	
	
	}
	
	
	


	
}
