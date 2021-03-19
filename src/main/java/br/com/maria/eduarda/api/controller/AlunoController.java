package br.com.maria.eduarda.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<Aluno> RecuperaAlunosPorId(@PathVariable Long alunoId) {
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionarNovoAluno(@Valid @RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
	@PutMapping("/{alunoId}")
	public ResponseEntity<Aluno> atualizar(@Valid @PathVariable Long alunoId,
			@RequestBody Aluno aluno) {
		
		if (!alunoRepository.existsById(alunoId)) {
			return ResponseEntity.notFound().build();
		}
		
		aluno.setId(alunoId);
		alunoRepository.save(aluno);
		
		return ResponseEntity.ok(aluno);
	}
	
	@DeleteMapping("/{alunoId}")
	public ResponseEntity<Void> remover(@PathVariable Long alunoId) {
		if (!alunoRepository.existsById(alunoId)) {
			return ResponseEntity.notFound().build();
		}
		
		alunoRepository.deleteById(alunoId);
		
		return ResponseEntity.noContent().build();
	}
	

	
	
	
}
