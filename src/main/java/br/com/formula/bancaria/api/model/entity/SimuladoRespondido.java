package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class SimuladoRespondido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIMULADO_RESPONDIDO_SEQ")
    @SequenceGenerator(name = "SIMULADO_RESPONDIDO_SEQ", sequenceName = "SEQ_SIMULADO_RESPONDIDO", initialValue = 1, allocationSize = 1)
    private Long id;
    private UUID uuid = UUID.randomUUID();

    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @Version
    private Long versao;

    @ManyToOne
    private Simulado simulado;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "simuladoRespondido", cascade = CascadeType.ALL)
    private List<QuestaoRespondida> questoes;

    public SimuladoRespondido() {
    }

    public SimuladoRespondido(Simulado simulado, Usuario usuario) {
        this.simulado = simulado;
        this.usuario = usuario;
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

    public Long getVersao() {
        return versao;
    }

    public void setVersao(Long versao) {
        this.versao = versao;
    }

    public Simulado getSimulado() {
        return simulado;
    }

    public void setSimulado(Simulado simulado) {
        this.simulado = simulado;
    }

    public List<QuestaoRespondida> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoRespondida> questoes) {
        this.questoes = questoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}