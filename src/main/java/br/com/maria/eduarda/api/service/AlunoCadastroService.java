package br.com.maria.eduarda.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maria.eduarda.api.handler.RecursoNaoEncontradoException;
import br.com.maria.eduarda.api.model.Aluno;
import br.com.maria.eduarda.api.repository.AlunoRepository;

@Service
public class AlunoCadastroService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno recuperaAlunosPorId(Long alunoId) {
		return this.alunoRepository.findById(alunoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada."));
	}

	public Aluno atualizar(Long alunoId, Aluno alunoAtualizado) {
		Aluno aluno = recuperaAlunosPorId(alunoId);
		aluno.setNome(alunoAtualizado.getNome());
		return salvar(aluno);
	}

	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	public void excluir(Long alunoId) {
		Aluno aluno = recuperaAlunosPorId(alunoId);
		alunoRepository.deleteById(alunoId);

	}

	}
