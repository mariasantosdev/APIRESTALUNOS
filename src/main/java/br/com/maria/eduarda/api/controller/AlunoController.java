package br.com.maria.eduarda.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maria.eduarda.api.model.Aluno;
import br.com.maria.eduarda.api.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
																																																																																																																																			
	
	@GetMapping
	public List<Aluno> listarTodosAlunos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{alunoId}")
	public ResponseEntity<Aluno> buscar(@PathVariable Long alunoId) {
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
}
