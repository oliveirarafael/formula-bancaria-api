package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class QuestaoRespondida {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTAO_RESPONDIDA_SEQ")
  @SequenceGenerator(name = "QUESTAO_RESPONDIDA_SEQ", sequenceName = "QUESTAO_RESPONDIDA_SIMULADO", initialValue = 1, allocationSize = 1)
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
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public LocalDateTime getDataHoraCriacao() {
    return dataHoraCriacao;
  }

  public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
    this.dataHoraCriacao = dataHoraCriacao;
  }

  public SimuladoRespondido getSimuladoRespondido() {
    return simuladoRespondido;
  }

  public void setSimuladoRespondido(SimuladoRespondido simuladoRespondido) {
    this.simuladoRespondido = simuladoRespondido;
  }

  public Questao getQuestao() {
    return questao;
  }

  public void setQuestao(Questao questao) {
    this.questao = questao;
  }

  public Resposta getResposta() {
    return resposta;
  }

  public void setResposta(Resposta resposta) {
    this.resposta = resposta;
  }
}