package br.com.formula.bancaria.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import br.com.formula.bancaria.api.model.Usuario;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    public void criaUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("user@email.com");
        usuario.setSenha("123456");      
        assertEquals(1, repository.save(usuario).getId());
    }

}