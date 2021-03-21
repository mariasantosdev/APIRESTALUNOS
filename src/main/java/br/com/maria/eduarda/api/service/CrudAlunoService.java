package br.com.maria.eduarda.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maria.eduarda.api.model.Aluno;
import br.com.maria.eduarda.api.repository.AlunoRepository;

@Service
public class CrudAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}	
	
	
	
		
	public void excluir(Long alunoId) {
		alunoRepository.deleteById(alunoId);
	
	
	}


	
}
