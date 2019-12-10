package br.com.formula.bancaria.api.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Simulado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private UUID uuid;
  private String titulo;
  private String descricao;
  private LocalDateTime dataHoraCriacao = LocalDateTime.now();
    
  /*@OneToMany(mappedBy = "simulado")
  private Collection<Modulo> modulos;  */


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
  

  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
      result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
      result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
      if (titulo == null) {
          if (other.titulo != null)
              return false;
      } else if (!titulo.equals(other.titulo))
          return false;
      if (uuid == null) {
          if (other.uuid != null)
              return false;
      } else if (!uuid.equals(other.uuid))
          return false;
      return true;
   }
  
}