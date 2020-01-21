package br.com.formula.bancaria.api.dto.cometario;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.formula.bancaria.api.model.entity.Comentario;

public class ComentarioDTO {

    private UUID uuid;
    private String descricao;
    private LocalDateTime dataCriacao;

    public ComentarioDTO(Comentario comentario){
        this.uuid = comentario.getUuid();
        this.descricao = comentario.getDescricao();
        this.dataCriacao = comentario.getDataHoraCriacao();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
  
}