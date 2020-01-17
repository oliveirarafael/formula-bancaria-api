package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Simulado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id;
  private UUID uuid = UUID.randomUUID();
  private String titulo;
  private String descricao;
  private LocalDateTime dataHoraCriacao = LocalDateTime.now();
  
  @Version
  private Long versao;

  @OneToMany(mappedBy = "simulado", cascade = CascadeType.ALL)
  private List<Modulo> modulos;

  public Simulado(){}

  public Simulado(String titulo, String descricao) {
	  this.titulo = titulo;
	  this.descricao = descricao;
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
  public String getTitulo() {
  	return titulo;
  }
  public void setTitulo(String titulo) {
  	this.titulo = titulo;
  }
  public String getDescricao() {
  	return descricao;
  }
  public void setDescricao(String descricao) {
  	this.descricao = descricao;
  }
  public LocalDateTime getDataHoraCriacao() {
  	return dataHoraCriacao;
  }
  public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
  	this.dataHoraCriacao = dataHoraCriacao;
  }

  public List<Modulo> getModulos() {
  	return modulos;
  }
  
  public void setModulos(List<Modulo> modulos) {
  	this.modulos = modulos;
  }


}