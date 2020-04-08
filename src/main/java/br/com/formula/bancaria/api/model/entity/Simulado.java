package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Simulado {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMULADO_SEQ")
  @SequenceGenerator(name = "SIMULADO_SEQ", 
                     sequenceName = "SEQ_SIMULADO",
                     initialValue = 1,
                     allocationSize = 1)  
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

  public Long getVersao() {
    return versao;
  }

  public void setVersao(Long versao) {
    this.versao = versao;
  }

  public List<Modulo> getModulos() {
    return modulos;
  }

  public void setModulos(List<Modulo> modulos) {
    this.modulos = modulos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
    result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
    result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
    result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
    if (versao == null) {
      if (other.versao != null)
        return false;
    } else if (!versao.equals(other.versao))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Simulado [dataHoraCriacao=" + dataHoraCriacao + ", descricao=" + descricao + ", id=" + id + ", modulos="
        + modulos + ", titulo=" + titulo + ", uuid=" + uuid + ", versao=" + versao + "]";
  }
   
}