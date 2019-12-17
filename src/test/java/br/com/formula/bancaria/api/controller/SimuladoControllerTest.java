package br.com.formula.bancaria.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SimuladoController.class)
public class SimuladoControllerTest {

    @Autowired
    private MockMvc mock;
    
    //@Test
    public void getSimulados() throws Exception{
        mock.perform(get("/simulados"))
            .andExpect(status().isOk());
    }
}