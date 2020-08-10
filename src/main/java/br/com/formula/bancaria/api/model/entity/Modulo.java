package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Version;

// import static javax.persistence.CascadeType.*;


@Entity
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID uuid = UUID.randomUUID();
	private String nome;
	private String descricao;

	private int quantidadeQuestoesPorSimulado;
	private LocalDateTime dataHoraCriacao = LocalDateTime.now();

	@Version
    private Long versao;

    @ManyToOne
    private Simulado simulado;
	
	@ManyToMany
	// @OneToMany(mappedBy = "modulo", cascade = { PERSIST, REMOVE })
	private List<Questao> questoes;
	
	public Modulo(){}
	
	public Modulo(String nome, String descricao, Integer quantidadeQuestoesPorSimulado, Simulado simulado) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeQuestoesPorSimulado = quantidadeQuestoesPorSimulado;
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

	public Integer getQuantidadeQuestoesPorSimulado() {
		return quantidadeQuestoesPorSimulado;
	}

	public void setQuantidadeQuestoesPorSimulado(Integer quantidadeQuestoesPorSimulado) {
		this.quantidadeQuestoesPorSimulado = quantidadeQuestoesPorSimulado;
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

	public Long getVersao() {
		return this.versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
		result = prime * result + ((simulado == null) ? 0 : simulado.hashCode());
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
		Modulo other = (Modulo) obj;
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
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [dataHoraCriacao=" + dataHoraCriacao + ", id=" + id + ", quantidadeQuestoesPorSimulado=" + quantidadeQuestoesPorSimulado
				+ ", questoes=" + questoes + ", simulado=" + simulado + ", uuid=" + uuid + ", versao=" + versao + "]";
	}

}