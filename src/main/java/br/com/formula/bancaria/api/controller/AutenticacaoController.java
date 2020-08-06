package br.com.formula.bancaria.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.formula.bancaria.api.dto.TokenDTO;
import br.com.formula.bancaria.api.form.LoginForm;
import br.com.formula.bancaria.api.model.entity.Usuario;
import br.com.formula.bancaria.api.service.TokenService;
import br.com.formula.bancaria.api.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private static final String BEARER = "Bearer";    
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginForm login){
        UsernamePasswordAuthenticationToken dadosLogin = login.converte();
        try{
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.token(authentication);
            Usuario usuario = (Usuario)authentication.getPrincipal();
            return ResponseEntity.ok(new TokenDTO(token, BEARER, usuario));    
        }catch(AuthenticationException e){
            throw new UsernameNotFoundException("Usuário inválido");
        }
    }

    @GetMapping("/esqueceu-senha")
    @Transactional
    public ResponseEntity<String> esqueceuSenha(@RequestParam("email") String email) {
        usuarioService.gerarSenhaProvisoria(email);
        return ResponseEntity.ok().body("Senha redefinida com sucesso");
    }
}