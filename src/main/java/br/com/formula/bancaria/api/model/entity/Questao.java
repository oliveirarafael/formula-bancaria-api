package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID uuid = UUID.randomUUID();

	private String assunto;
	@Column(length = 1000)
	private String enunciado;
	@Column(length = 1000)
	private String comentario;
	private LocalDateTime dataHoraCriacao = LocalDateTime.now();

	@Version
	private Long versao;

	@OneToMany(mappedBy = "questao", cascade = { PERSIST, REMOVE })
	private List<Resposta> respostas;

	// @OneToMany
	// private List<Modulo> modulos;

	public Questao() {
	}

	// public Questao(String assunto, String enunciado, List<Resposta> respostas, List<Modulo> modulos,
	// 		String comentario) {
	// 	this.assunto = assunto;
	// 	this.enunciado = enunciado;
	// 	this.respostas = respostas;
	// 	this.modulos = modulos;
	// 	this.comentario = comentario;
	// }

	public Questao(String assunto, String enunciado, List<Resposta> respostas, String comentario) {
		this.assunto = assunto;
		this.enunciado = enunciado;
		this.respostas = respostas;
		this.comentario = comentario;
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

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String descricao) {
		this.enunciado = descricao;
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

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	// public List<Modulo> getModulos() {
	// 	return modulos;
	// }

	// public void setModulos(List<Modulo> modulos) {
	// 	this.modulos = modulos;
	// }

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		// result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
		result = prime * result + ((respostas == null) ? 0 : respostas.hashCode());
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
		Questao other = (Questao) obj;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (dataHoraCriacao == null) {
			if (other.dataHoraCriacao != null)
				return false;
		} else if (!dataHoraCriacao.equals(other.dataHoraCriacao))
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		// if (modulos == null) {
		// 	if (other.modulos != null)
		// 		return false;
		// } else if (!modulos.equals(other.modulos))
		// 	return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
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
		return "Questao [assunto=" + assunto + ", comentario=" + comentario + ", dataHoraCriacao=" + dataHoraCriacao
				+ ", descricao=" + enunciado + ", id=" + id + ", respostas=" + respostas
				+ ", uuid=" + uuid + ", versao=" + versao + "]";
	}

}