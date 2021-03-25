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

	public Aluno salvar(Aluno aluno)
	{
		return alunoRepository.save(aluno);
	}

	public Aluno recuperaAlunoPorId(Long alunoId) {
		return this.alunoRepository.findById(alunoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada."));
	}

	public Aluno atualizar(Long alunoId, Aluno alunoAtualizado) {
		Aluno aluno = recuperaAlunoPorId(alunoId);
		aluno.setNome(alunoAtualizado.getNome());
		aluno.setIdade(alunoAtualizado.getIdade());
		return salvar(aluno);
	}

	public List<Aluno> listar()
	{
		return alunoRepository.findAll();
	}

	public void excluir(Long alunoId) {
		Aluno aluno = recuperaAlunoPorId(alunoId);
		alunoRepository.deleteById(alunoId);
	}
}
