package br.com.formula.bancaria.api.dto.modulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class DetalheModuloDTO {

    private List<QuestaoDTO> questoes;

    public DetalheModuloDTO(Modulo modulo){
        this.questoes = new ArrayList<>();
        this.questoes.addAll(modulo.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList()));
        embaralhaQuestoes();
    }
    
    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }
    
    private void embaralhaQuestoes(){
        Collections.shuffle(questoes);
    }
    
}