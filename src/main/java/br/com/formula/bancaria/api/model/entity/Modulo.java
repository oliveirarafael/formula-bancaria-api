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
import javax.persistence.Version;

@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid = UUID.randomUUID();
    private String titulo;
    private Long percentual;
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

	@Version
    private Long versao;

    @ManyToOne
    private Simulado simulado;
	
    @ManyToMany
	private List<Questao> questoes;
	
	public Modulo(){}
	
	public Modulo(String titulo, Long percentual, Simulado simulado) {
		this.titulo = titulo;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getPercentual() {
		return percentual;
	}

	public void setPercentual(Long percentual) {
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

	public void setPerguntas(List<Questao> questoes) {
		this.questoes = questoes;
	}

    
}