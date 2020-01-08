package br.com.formula.bancaria.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.formula.bancaria.api.model.entity.Pergunta;

public class PerguntaDTO {

    private UUID uuid;
    private String descricao;
    private LocalDateTime dataHoraCriacao;

    public PerguntaDTO(Pergunta pegunta){
        this.uuid = pegunta.getUuid();
        this.descricao = pegunta.getDescricao();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return descricao;
    }
}