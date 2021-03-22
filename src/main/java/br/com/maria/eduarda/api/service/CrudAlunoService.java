package br.com.maria.eduarda.api.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	
	public ResponseEntity<Aluno> RecuperaAlunosPorId(Long alunoId) {
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	public ResponseEntity<Aluno> atualizar(Long alunoId, Aluno aluno){
		if (!alunoRepository.existsById(alunoId)) {
			return ResponseEntity.notFound().build();
		}
		
		aluno.setId(alunoId);
		alunoRepository.save(aluno);
		
		return ResponseEntity.ok(aluno);
	
	}
	
	
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	
		
	public void excluir(Long alunoId) {
		alunoRepository.deleteById(alunoId);
	
	
	}
	
	
	


	
}
