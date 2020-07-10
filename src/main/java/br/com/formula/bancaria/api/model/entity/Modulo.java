package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private UUID uuid = UUID.randomUUID();
	private String nome;
	private String descricao;
	private Integer percentual;

	@Column(name = "data_hora_criacao")
	private LocalDateTime dataHoraCriacao = LocalDateTime.now();

	@ManyToOne
	@Column(name = "simulado")
    private Simulado simulado;
	
	@ManyToMany
	@JoinTable(name = "modulo_questao")
	private List<Questao> questoes;
	
	public Modulo(){}
	
	public Modulo(String nome, String descricao, Integer percentual, Simulado simulado) {
		this.nome = nome;
		this.descricao = descricao;
		this.percentual = percentual;
		this.simulado = simulado;
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

	public Integer getPercentual() {
		return percentual;
	}

	public void setPercentual(Integer percentual) {
		this.percentual = percentual;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public Simulado getSimulado() {
		return simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((percentual == null) ? 0 : percentual.hashCode());
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
		result = prime * result + ((simulado == null) ? 0 : simulado.hashCode());
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
		Modulo other = (Modulo) obj;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (percentual == null) {
			if (other.percentual != null)
				return false;
		} else if (!percentual.equals(other.percentual))
			return false;
		if (questoes == null) {
			if (other.questoes != null)
				return false;
		} else if (!questoes.equals(other.questoes))
			return false;
		if (simulado == null) {
			if (other.simulado != null)
				return false;
		} else if (!simulado.equals(other.simulado))
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
		return "Modulo [dataHoraCriacao=" + dataHoraCriacao + ", descricao=" + descricao + ", id=" + id + ", nome="
				+ nome + ", percentual=" + percentual + ", questoes=" + questoes + ", simulado=" + simulado + ", uuid="
				+ uuid + "]";
	}

}