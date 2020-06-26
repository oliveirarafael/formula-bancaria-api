package br.com.formula.bancaria.api.dto.questaoRespondida;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
import br.com.formula.bancaria.api.dto.resposta.RespostaDTO;
import br.com.formula.bancaria.api.model.entity.QuestaoRespondida;

public class QuestaoRespondidaDTO {
    private UUID uuid;
    private LocalDateTime dataHoraCriacao;
    private QuestaoDTO questao;
    private RespostaDTO respostaEscolhida;
    private Boolean correta;

    public QuestaoRespondidaDTO(QuestaoRespondida questaoRespondida) {
        this.setUuid(questaoRespondida.getUuid());
        this.setDataHoraCriacao(questaoRespondida.getDataHoraCriacao());
        this.questao = new QuestaoDTO(questaoRespondida.getQuestao());
        this.respostaEscolhida = new RespostaDTO(questaoRespondida.getResposta());
        this.correta = this.questao.getRespostas().stream().filter(r -> r.getCorreta()).findFirst().get().getCorreta();
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public QuestaoDTO getQuestao() {
        return questao;
    }

    public void setQuestao(QuestaoDTO questao) {
        this.questao = questao;
    }

    public RespostaDTO getResposta() {
        return respostaEscolhida;
    }

    public void setResposta(RespostaDTO respostaEscolhida) {
        this.respostaEscolhida = respostaEscolhida;
    }

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }
}