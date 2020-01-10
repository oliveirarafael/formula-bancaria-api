package br.com.formula.bancaria.api.dto.pergunta;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.resposta.RespostaDTO;
import br.com.formula.bancaria.api.model.entity.Pergunta;

public class PerguntaDTO {

    private UUID uuid;
    private String descricao;
    private List<RespostaDTO> respostas;

    public PerguntaDTO(Pergunta pergunta){
        this.uuid = pergunta.getUuid();
        this.descricao = pergunta.getDescricao();
        this.respostas.addAll(pergunta.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return descricao;
    }
}