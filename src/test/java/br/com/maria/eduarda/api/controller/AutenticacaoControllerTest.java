package br.com.maria.eduarda.api.controller;



import java.net.URI;

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


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void deveriaDevolver201CreatedParaRegistro() throws Exception {
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
    public void deveriaDevolverOk_RegistroExibido() throws Exception {
        URI uri = new URI("/aluno");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));

    }





}
