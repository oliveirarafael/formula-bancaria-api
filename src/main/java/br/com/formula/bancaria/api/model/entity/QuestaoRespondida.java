package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questao_respondida")
public class QuestaoRespondida {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UUID uuid = UUID.randomUUID();
  
  @Column(name = "data_hora_criacao")
  private LocalDateTime dataHoraCriacao = LocalDateTime.now();

  @ManyToOne
  @Column(name = "simulado_respondido")
  private SimuladoRespondido simuladoRespondido;

  @ManyToOne
  @Column(name = "questao")
  private Questao questao;

  @ManyToOne
  @Column(name = "resposta")
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
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestaoRespondida other = (QuestaoRespondida) obj;
    if (dataHoraCriacao == null) {
      if (other.dataHoraCriacao != null)
        return false;
    } else if (!dataHoraCriacao.equals(other.dataHoraCriacao))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (questao == null) {
      if (other.questao != null)
        return false;
    } else if (!questao.equals(other.questao))
      return false;
    if (resposta == null) {
      if (other.resposta != null)
        return false;
    } else if (!resposta.equals(other.resposta))
      return false;
    if (simuladoRespondido == null) {
      if (other.simuladoRespondido != null)
        return false;
    } else if (!simuladoRespondido.equals(other.simuladoRespondido))
      return false;
    if (uuid == null) {
      if (other.uuid != null)
        return false;
    } else if (!uuid.equals(other.uuid))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((questao == null) ? 0 : questao.hashCode());
    result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
    result = prime * result + ((simuladoRespondido == null) ? 0 : simuladoRespondido.hashCode());
    result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "QuestaoRespondida [dataHoraCriacao=" + dataHoraCriacao + ", id=" + id + ", questao=" + questao
        + ", resposta=" + resposta + ", simuladoRespondido=" + simuladoRespondido + ", uuid=" + uuid + "]";
  }

}