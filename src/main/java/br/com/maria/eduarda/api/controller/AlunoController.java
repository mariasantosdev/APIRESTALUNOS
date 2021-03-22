package br.com.maria.eduarda.api.controller;

import java.util.List;


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
import br.com.maria.eduarda.api.service.CrudAlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	
	@Autowired
	private CrudAlunoService crudAlunoService;
	
																																																																																																																																			
	
	@GetMapping
	public List<Aluno> listar() {
		return crudAlunoService.listar();
	}
	
	@GetMapping("/{alunoId}")
	public ResponseEntity<Aluno> RecuperaAlunosPorId(@PathVariable Long alunoId) {
		return crudAlunoService.RecuperaAlunosPorId(alunoId);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionarNovoAluno(@Valid @RequestBody Aluno aluno) {
		return crudAlunoService.salvar(aluno);
	}

	
	@PutMapping("/{alunoId}")
	public ResponseEntity<Aluno> atualizar(@Valid @PathVariable Long alunoId,
			@RequestBody Aluno aluno) {
		return crudAlunoService.atualizar(alunoId, aluno);
	}
	
	
	@DeleteMapping("/{alunoId}")
	public ResponseEntity<Void> remover(@PathVariable Long alunoId) {
	
		
		crudAlunoService.excluir(alunoId);
		
		return ResponseEntity.noContent().build();
	}
	


	
	
	
}
