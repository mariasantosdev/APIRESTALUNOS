package br.com.maria.eduarda.api.controller;

import java.net.URI;

import br.com.maria.eduarda.api.handler.RecursoNaoEncontradoException;
import br.com.maria.eduarda.api.model.Aluno;
import br.com.maria.eduarda.api.repository.AlunoRepository;
import br.com.maria.eduarda.api.service.AlunoCadastroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoRepository  alunoRepository;

    @Autowired
    private AlunoCadastroService  alunoCadastroService;



    @Test
    public void deveRetornarCreated_ParaRegistro() throws Exception {
        URI uri = new URI("/aluno");
        String json = "{\"nome\":\"Fabiana\",\"idade\":\"18\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }

    @Test
    public void deveRetornarBadRequest_PorNaoTerRegistroObrigatorio() throws Exception {
        URI uri = new URI("/aluno");
        String json = "{\"nome\":\"\",\"idade\":\"18\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void deveDevolverOk_ParaRegistrosExibido() throws Exception {
        URI uri = new URI("/aluno");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveDevolverOk_ParaRegistroDeletado() throws Exception {

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Fabiana");
        aluno.setIdade(24);
        alunoRepository.save(aluno);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/aluno/{alunoId}", aluno.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void deveDevolver_RegistroAtualizado() throws Exception {

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Jose");
        aluno.setIdade(40);
        alunoRepository.save(aluno);
        String json = "{\"nome\":\"Gustavo\",\"idade\":\"18\"}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/aluno/{alunoId}", aluno.getId())
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                    .andExpect(content().json("{\"nome\":\"Gustavo\",\"idade\":\"18\"}"));
    }

    @Test
    public void devolverNotFound_RegistroNaoEncontrado() throws Exception {

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Jose");
        aluno.setIdade(40);
        alunoRepository.save(aluno);
        alunoCadastroService.excluir(1L);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/aluno/{alunoId}", aluno.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));

    }







}
