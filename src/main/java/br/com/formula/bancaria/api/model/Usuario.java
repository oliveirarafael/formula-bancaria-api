package br.com.formula.bancaria.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    private String email;
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
    
    public Long getId() {
		return id;
	}
	public void setId(final Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(final String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(final String senha) {
		this.senha = senha;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
 
}