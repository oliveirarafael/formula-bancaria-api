package br.com.formula.bancaria.api.dto.usuario;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.model.entity.Usuario;

public class UsuarioDTO {

    private UUID uuid;
    private String nome;
    private String email;
    private LocalDateTime dataHoraCriacao;
    private Boolean assinante;
    private Boolean ehAluno;
    private Boolean ehProfessor;

    public UsuarioDTO(Usuario usuario) {
        this.uuid = usuario.getUuid();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataHoraCriacao = usuario.getDataHoraCriacao();
        this.setAssinante(usuario.getAssinante());
        this.setEhAluno(usuario.possuiPerfilAluno());
        this.setEhProfessor(usuario.possuiPerfilProfessor());
    }

    public Boolean getEhProfessor() {
        return ehProfessor;
    }

    public void setEhProfessor(Boolean ehProfessor) {
        this.ehProfessor = ehProfessor;
    }

    public Boolean getEhAluno() {
        return ehAluno;
    }

    public void setEhAluno(Boolean ehAluno) {
        this.ehAluno = ehAluno;
    }

    public static Page<UsuarioDTO> converte(Page<Usuario> usuarios) {
        if(Optional.ofNullable(usuarios).isPresent()){
           return usuarios.map(UsuarioDTO::new);
        }
        return Page.empty();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDateTime getDataHoraCriacao() {
        return this.dataHoraCriacao;
    }

    public Boolean getAssinante() {
        return assinante;
    }

    public void setAssinante(Boolean assinante) {
        this.assinante = assinante;
    }
}