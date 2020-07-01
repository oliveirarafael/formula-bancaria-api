package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class SimuladoRespondido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public UUID getUuid() {
        return uuid;
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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SimuladoRespondido)) {
            return false;
        }
        SimuladoRespondido simuladoRespondido = (SimuladoRespondido) o;
        return Objects.equals(id, simuladoRespondido.id) && Objects.equals(uuid, simuladoRespondido.uuid) && Objects.equals(dataHoraCriacao, simuladoRespondido.dataHoraCriacao) && Objects.equals(versao, simuladoRespondido.versao) && Objects.equals(simulado, simuladoRespondido.simulado) && Objects.equals(usuario, simuladoRespondido.usuario) && Objects.equals(questoes, simuladoRespondido.questoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, dataHoraCriacao, versao, simulado, usuario, questoes);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", uuid='" + getUuid() + "'" +
            ", dataHoraCriacao='" + getDataHoraCriacao() + "'" +
            ", versao='" + getVersao() + "'" +
            ", simulado='" + getSimulado() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", questoes='" + getQuestoes() + "'" +
            "}";
    }

}