package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Simulado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UUID uuid = UUID.randomUUID();
  private String nome;
  private String descricao;

  @Column(name = "quantidade_questao_por_execucao")
  private Integer quantidadeQuestaoPorExecucao;

  @Column(name = "data_hora_criacao")
  private LocalDateTime dataHoraCriacao = LocalDateTime.now();

  @OneToMany(mappedBy = "simulado", cascade = CascadeType.ALL)
  private List<Modulo> modulos;
  
  @ManyToMany
  private List<Questao> questoes;

  public Simulado() {
  }

  public Simulado(final String titulo, final String descricao, Integer quantidadeQuestaoPorExecucao) {
    this.nome = titulo;
    this.descricao = descricao;
    this.setQuantidadeQuestaoPorExecucao(quantidadeQuestaoPorExecucao);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(final UUID uuid) {
    this.uuid = uuid;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  public LocalDateTime getDataHoraCriacao() {
    return dataHoraCriacao;
  }

  public void setDataHoraCriacao(final LocalDateTime dataHoraCriacao) {
    this.dataHoraCriacao = dataHoraCriacao;
  }
  
  public Integer getQuantidadeQuestaoPorExecucao() {
    return quantidadeQuestaoPorExecucao;
  }

  public void setQuantidadeQuestaoPorExecucao(Integer quantidadeQuestaoPorExecucao) {
    this.quantidadeQuestaoPorExecucao = quantidadeQuestaoPorExecucao;
  }
  
  public List<Modulo> getModulos() {
    return modulos;
  }

  public void setModulos(final List<Modulo> modulos) {
    this.modulos = modulos;
  }

  public List<Questao> getQuestoes() {
    return questoes;
  }

  public void setQuestoes(final List<Questao> questoes) {
    this.questoes = questoes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((quantidadeQuestaoPorExecucao == null) ? 0 : quantidadeQuestaoPorExecucao.hashCode());
    result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
    result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Simulado other = (Simulado) obj;
    if (dataHoraCriacao == null) {
      if (other.dataHoraCriacao != null)
        return false;
    } else if (!dataHoraCriacao.equals(other.dataHoraCriacao))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (modulos == null) {
      if (other.modulos != null)
        return false;
    } else if (!modulos.equals(other.modulos))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (quantidadeQuestaoPorExecucao == null) {
      if (other.quantidadeQuestaoPorExecucao != null)
        return false;
    } else if (!quantidadeQuestaoPorExecucao.equals(other.quantidadeQuestaoPorExecucao))
      return false;
    if (questoes == null) {
      if (other.questoes != null)
        return false;
    } else if (!questoes.equals(other.questoes))
      return false;
    if (uuid == null) {
      if (other.uuid != null)
        return false;
    } else if (!uuid.equals(other.uuid))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Simulado [dataHoraCriacao=" + dataHoraCriacao + ", descricao=" + descricao + ", id=" + id + ", modulos="
        + modulos + ", nome=" + nome + ", quantidadeQuestaoPorExecucao=" + quantidadeQuestaoPorExecucao + ", questoes="
        + questoes + ", uuid=" + uuid + "]";
  }
}