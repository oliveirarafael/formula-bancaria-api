package br.com.formula.bancaria.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import br.com.formula.bancaria.api.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
    
    private Date hoje = new Date();

    @Value("${formula.bancaria.api.jwt.expiration}")
    private String expiration;

    @Value("${formula.bancaria.api.jwt.secret}")
    private String secret;

    private Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

	public String token(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                   .setIssuer("API Formula Bancaria")
                   .setSubject(usuarioLogado.getId().toString())
                   .setIssuedAt(hoje)
                   .setExpiration(dataExpiracao)
                   .signWith(SignatureAlgorithm.HS256, secret)
                   .compact();
	}

}
