package br.com.formula.bancaria.api.form.questaoRespondida;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.model.entity.QuestaoRespondida;
import br.com.formula.bancaria.api.model.entity.Resposta;
import br.com.formula.bancaria.api.model.entity.SimuladoRespondido;

public class CreateQuestaoRespondidaForm {
    @NotNull @NotEmpty
    private UUID questaoUUID;
    @NotNull @NotEmpty
    private UUID respostaEscolhidaUUID;

    public QuestaoRespondida converte(SimuladoRespondido simuladoRespondido, Questao questao, Resposta resposta){
        return new QuestaoRespondida(simuladoRespondido, questao, resposta);
    }

    public UUID getQuestaoUuid() {
        return questaoUUID;
    }

    public void setQuestaoUuid(UUID questaoUUID) {
        this.questaoUUID = questaoUUID;
    }

    public UUID getRespostaEscolhidaUuid() {
        return respostaEscolhidaUUID;
    }

    public void setRespostaEscolhidaUuid(UUID respostaEscolhidaUUID) {
        this.respostaEscolhidaUUID = respostaEscolhidaUUID;
    }
}