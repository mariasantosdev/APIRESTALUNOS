package br.com.maria.eduarda.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.maria.eduarda.api.service.AlunoCadastroService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoCadastroService alunoCadastroService;

	@GetMapping
	public List<Aluno> listar() {
		return alunoCadastroService.listar();
	}

	@GetMapping("/{alunoId}")
	public Aluno recuperaAlunosPorId(@PathVariable Long alunoId) {
		Aluno aluno = this.alunoCadastroService.recuperaAlunosPorId(alunoId);
		return aluno;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionarNovoAluno(@Valid @RequestBody Aluno aluno) {
		return alunoCadastroService.salvar(aluno);
	}

	@PutMapping("/{alunoId}")
	public Aluno atualizar(@Valid @PathVariable Long alunoId, @RequestBody Aluno aluno) {
		return alunoCadastroService.atualizar(alunoId, aluno);

	}

	@DeleteMapping("/{alunoId}")
	public void remover(@PathVariable Long alunoId) {
		alunoCadastroService.excluir(alunoId);
	}

	}
