package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "simulado_respondido")
public class SimuladoRespondido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid = UUID.randomUUID();

    @Column(name = "data_hora_criacao")
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @ManyToOne
    @Column(name = "simualdo")
    private Simulado simulado;
    @ManyToOne
    @Column(name = "usuario")
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimuladoRespondido other = (SimuladoRespondido) obj;
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
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataHoraCriacao == null) ? 0 : dataHoraCriacao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
        result = prime * result + ((simulado == null) ? 0 : simulado.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SimuladoRespondido [dataHoraCriacao=" + dataHoraCriacao + ", id=" + id + ", questoes=" + questoes
                + ", simulado=" + simulado + ", usuario=" + usuario + ", uuid=" + uuid + "]";
    }

}