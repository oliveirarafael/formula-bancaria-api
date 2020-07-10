package br.com.formula.bancaria.api.form.usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Usuario;

public class CreateUsuarioForm {
    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty
    private String sobrenome;

    @NotNull @NotEmpty
    private String email;
    
    @NotNull @NotEmpty
	private String senha;

    public Usuario converte(){
        return new Usuario(nome, sobrenome, email, senha);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}