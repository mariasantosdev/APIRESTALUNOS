package br.com.maria.eduarda.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	

}
