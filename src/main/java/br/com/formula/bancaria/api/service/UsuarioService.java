package br.com.formula.bancaria.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formula.bancaria.api.config.validacao.exception.NotFoundException;
import br.com.formula.bancaria.api.model.entity.Usuario;
import br.com.formula.bancaria.api.repository.UsuarioRepository;
import br.com.formula.bancaria.api.util.GeradorSenhaUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private EmailService emailService;

    public void gerarSenhaProvisoria(String email) {
        System.out.println("Email =====>> "+email);
        Optional<Usuario> usuarioConsultado = repository.findByEmail(email);
         
        if(usuarioConsultado.isPresent()){
            Usuario usuarioCadastrado = usuarioConsultado.get();
            String senhaProvisoria = GeradorSenhaUtil.gerarSenha();
            usuarioCadastrado.setSenha(new BCryptPasswordEncoder().encode(senhaProvisoria));
            repository.save(usuarioCadastrado);
            emailService.enviar(email, "Senha provisória", senhaProvisoria);
        }else{
            throw new NotFoundException("Usuário não foi encontrado");
        }

    }
    
}