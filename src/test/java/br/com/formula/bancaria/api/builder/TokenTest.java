package br.com.formula.bancaria.api.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import br.com.formula.bancaria.api.form.LoginForm;
import br.com.formula.bancaria.api.service.TokenService;

@TestComponent
public class TokenTest {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authManager;
    
    private LoginForm form = new LoginForm();
    
    private static String token;

    public String token(){
        if(token != null){
            return token;
        }

        token = tokenService.token(auth());
        return token;
    }

    private Authentication auth(){
        form.setEmail("user@email.com.br");
        form.setSenha("123456");
        return authManager.authenticate(form.converte());
    }
    
}