package br.com.formula.bancaria.api.dto.questao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.dto.resposta.RespostaDTO;
import br.com.formula.bancaria.api.model.entity.Questao;

public class QuestaoDTO {

    private UUID uuid;
    private String enunciado;
    private List<RespostaDTO> respostas = new ArrayList<>();

    public QuestaoDTO(Questao pergunta){
        this.uuid = pergunta.getUuid();
        this.enunciado = pergunta.getEnunciado();
        this.respostas.addAll(pergunta.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
        embaralhaRespostas();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return enunciado;
    }

    public List<RespostaDTO> getRespostas() {  
        return this.respostas;
    }

    private void embaralhaRespostas(){
      Collections.shuffle(respostas);
    }

    public static Page<QuestaoDTO> converte(Page<Questao> questoes){
        if(Optional.ofNullable(questoes).isPresent()){
           return questoes.map(QuestaoDTO::new);
        }
        return Page.empty();
    }
}