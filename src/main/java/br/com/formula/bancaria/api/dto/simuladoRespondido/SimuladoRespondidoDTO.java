package br.com.formula.bancaria.api.dto.simuladoRespondido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.UUID;

import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.dto.simulado.SimuladoDTO;
import br.com.formula.bancaria.api.dto.questaoRespondida.QuestaoRespondidaDTO;
import br.com.formula.bancaria.api.model.entity.SimuladoRespondido;

public class SimuladoRespondidoDTO {
    private UUID uuid;
    private LocalDateTime dataHoraCriacao;
    private SimuladoDTO simulado;
    private List<QuestaoRespondidaDTO> questoesRespondidas = new ArrayList<>();

    public SimuladoRespondidoDTO(SimuladoRespondido simuladoRespondido){
        this.uuid = simuladoRespondido.getUuid();
        this.dataHoraCriacao = simuladoRespondido.getDataHoraCriacao();
        this.simulado =  new SimuladoDTO(simuladoRespondido.getSimulado());
        this.questoesRespondidas.addAll(simuladoRespondido.getQuestoes().stream().map(QuestaoRespondidaDTO::new).collect(Collectors.toList()));
     }

    public static Page<SimuladoRespondidoDTO> converte(Page<SimuladoRespondido> simulados){
        if(Optional.ofNullable(simulados).isPresent()){
           return simulados.map(SimuladoRespondidoDTO::new);
        }
        return Page.empty();
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

    public SimuladoDTO getSimulado() {
        return simulado;
    }

    public void setSimulado(SimuladoDTO simulado) {
        this.simulado = simulado;
    }

    public List<QuestaoRespondidaDTO> getQuestoesRespondidas() {
        return questoesRespondidas;
    }

    public void setQuestoesRespondidas(List<QuestaoRespondidaDTO> questoesRespondidas) {
        this.questoesRespondidas = questoesRespondidas;
    }
}