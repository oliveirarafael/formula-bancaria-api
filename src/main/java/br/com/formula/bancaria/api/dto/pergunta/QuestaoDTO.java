package br.com.formula.bancaria.api.dto.pergunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.resposta.RespostaDTO;
import br.com.formula.bancaria.api.model.entity.Questao;

public class QuestaoDTO {

    private UUID uuid;
    private String descricao;
    private List<RespostaDTO> respostas = new ArrayList();

    public QuestaoDTO(Questao pergunta){
        this.uuid = pergunta.getUuid();
        this.descricao = pergunta.getDescricao();
        this.respostas.addAll(pergunta.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
        embaralhaRespostas();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<RespostaDTO> getRespostas() {  
        return this.respostas;
    }

    private void embaralhaRespostas(){
      Collections.shuffle(respostas);
    }

}