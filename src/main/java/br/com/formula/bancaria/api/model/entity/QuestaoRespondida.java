package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class QuestaoRespondida {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UUID uuid = UUID.randomUUID();

  private LocalDateTime dataHoraCriacao = LocalDateTime.now();

  @Version
  private Long versao;

  @ManyToOne
  private SimuladoRespondido simuladoRespondido;

  @ManyToOne
  private Questao questao;

  @ManyToOne
  private Resposta resposta;

  public QuestaoRespondida() {
  }

  public QuestaoRespondida(SimuladoRespondido simuladoRespondido, Questao questao, Resposta resposta) {
    this.simuladoRespondido = simuladoRespondido;
    this.questao = questao;
    this.resposta = resposta;
  }

  public QuestaoRespondida(Questao questao, Resposta resposta) {
    this.questao = questao;
    this.resposta = resposta;
  }

  public Long getId() {
    return this.id;
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public LocalDateTime getDataHoraCriacao() {
    return this.dataHoraCriacao;
  }

  public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
    this.dataHoraCriacao = dataHoraCriacao;
  }

  public Long getVersao() {
    return this.versao;
  }

  public void setVersao(Long versao) {
    this.versao = versao;
  }

  public SimuladoRespondido getSimuladoRespondido() {
    return this.simuladoRespondido;
  }

  public void setSimuladoRespondido(SimuladoRespondido simuladoRespondido) {
    this.simuladoRespondido = simuladoRespondido;
  }

  public Questao getQuestao() {
    return this.questao;
  }

  public void setQuestao(Questao questao) {
    this.questao = questao;
  }

  public Resposta getResposta() {
    return this.resposta;
  }

  public void setResposta(Resposta resposta) {
    this.resposta = resposta;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o instanceof QuestaoRespondida)) {
        return false;
    }
    QuestaoRespondida questaoRespondida = (QuestaoRespondida) o;
    return Objects.equals(id, questaoRespondida.id) && Objects.equals(uuid, questaoRespondida.uuid) && Objects.equals(dataHoraCriacao, questaoRespondida.dataHoraCriacao) && Objects.equals(versao, questaoRespondida.versao) && Objects.equals(simuladoRespondido, questaoRespondida.simuladoRespondido) && Objects.equals(questao, questaoRespondida.questao) && Objects.equals(resposta, questaoRespondida.resposta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uuid, dataHoraCriacao, versao, simuladoRespondido, questao, resposta);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", uuid='" + getUuid() + "'" +
      ", dataHoraCriacao='" + getDataHoraCriacao() + "'" +
      ", versao='" + getVersao() + "'" +
      ", simuladoRespondido='" + getSimuladoRespondido() + "'" +
      ", questao='" + getQuestao() + "'" +
      ", resposta='" + getResposta() + "'" +
      "}";
  }

}