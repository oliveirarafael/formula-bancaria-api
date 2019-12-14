package br.com.formula.bancaria.api.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class Usuario {

    private Long id;
    private String email;
    private String senha;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

    
    
}