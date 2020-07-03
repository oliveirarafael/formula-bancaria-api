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

    private final Long id;
    private final UUID uuid;
    private final String enunciado;
    private final String assunto;
    private final String comentario;
    private final List<RespostaDTO> respostas = new ArrayList<>();

    public QuestaoDTO(final Questao pergunta) {
        this.id = pergunta.getId();
        this.uuid = pergunta.getUuid();
        this.enunciado = pergunta.getEnunciado();
        this.assunto = pergunta.getAssunto();
        this.comentario = pergunta.getComentario();
        this.respostas.addAll(pergunta.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
        embaralhaRespostas();
    }

    public String getComentario() {
        return comentario;
    }

    public String getAssunto() {
        return assunto;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<RespostaDTO> getRespostas() {
        return this.respostas;
    }

    private void embaralhaRespostas() {
        Collections.shuffle(respostas);
    }

    public static Page<QuestaoDTO> converte(final Page<Questao> questoes) {
        if(Optional.ofNullable(questoes).isPresent()){
           return questoes.map(QuestaoDTO::new);
        }
        return Page.empty();
    }
}