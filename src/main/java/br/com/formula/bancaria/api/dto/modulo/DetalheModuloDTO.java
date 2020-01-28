package br.com.formula.bancaria.api.dto.modulo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.pergunta.QuestaoDTO;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class DetalheModuloDTO {

    private String titulo;
    private List<QuestaoDTO> questoes;

    public DetalheModuloDTO(Modulo modulo){
        this.titulo = modulo.getTitulo();
        this.questoes.addAll(modulo.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList()));
        embaralhaQuestoes();
    }
    
    public String getTitulo() {
        return titulo;
    }

    public List<QuestaoDTO> getPerguntas() {
        return questoes;
    }
    
    private void embaralhaQuestoes(){
        Collections.shuffle(questoes);
    }
    
}