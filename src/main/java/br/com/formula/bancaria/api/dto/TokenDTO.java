package br.com.formula.bancaria.api.dto;

import br.com.formula.bancaria.api.dto.usuario.UsuarioDTO;
import br.com.formula.bancaria.api.model.entity.Usuario;

public class TokenDTO {

    private String token;
	private String tipo;
	private UsuarioDTO usuario;
    
    public TokenDTO(String token, String tipo, Usuario usuario) {
		this.token = token;
		this.tipo = tipo;
		this.usuario = new UsuarioDTO(usuario);
    }

	public String getToken() {
		return token;
	}
	public String getTipo() {
		return tipo;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}
    
}