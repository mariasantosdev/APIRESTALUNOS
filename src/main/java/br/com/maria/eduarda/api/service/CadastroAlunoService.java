package br.com.maria.eduarda.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maria.eduarda.api.repository.AlunoRepository;

@Service
public class CadastroAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	

	
}
