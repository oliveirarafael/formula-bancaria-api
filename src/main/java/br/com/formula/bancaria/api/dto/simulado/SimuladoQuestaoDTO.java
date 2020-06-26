package br.com.formula.bancaria.api.dto.simulado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoQuestaoDTO {
    private String titulo;
    private List<QuestaoDTO> questoes = new ArrayList<>();

    public SimuladoQuestaoDTO(Simulado simulado) {
        this.setTitulo(simulado.getTitulo());
        this.questoes.addAll(simulado.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList()));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoDTO> questoes) {
        this.questoes = questoes;
    }
}