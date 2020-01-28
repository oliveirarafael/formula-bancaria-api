package br.com.formula.bancaria.api.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.com.formula.bancaria.api.builder.TokenTest;
import br.com.formula.bancaria.api.form.LoginForm;
import br.com.formula.bancaria.api.form.simulado.CreateSimuladoForm;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.service.TokenService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
public class SimuladoControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private TokenTest token;
    
    @Test
    public void getSimulados() throws Exception{    
        mock.perform(get("/simulados").header("Authorization", "Bearer "+token.token()))
            .andExpect(status().isOk());
    }

    @Test
    public void criaSimulado() throws Exception {
        CreateSimuladoForm form = new CreateSimuladoForm();
        form.setTitulo("CPA 10");
        form.setDescricao("Curso de CPA 10");

        Simulado simulado = new Simulado();
        
        Mockito.when(form.converte()).thenReturn(simulado);

        ObjectMapper json = new ObjectMapper();
        String jsonString = json.writeValueAsString(simulado);
        
        mock.perform(post("/simulados")
                     .contentType(MediaType.APPLICATION_JSON)
                     .accept(MediaType.APPLICATION_JSON)
                     .content(jsonString))
            .andExpect(status().isCreated())
            .andExpect(content().json(jsonString));
    }
}