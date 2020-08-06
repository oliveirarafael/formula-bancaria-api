package br.com.formula.bancaria.api.dto.simuladoRespondido;

import java.util.ArrayList;
import java.util.List;

public class SimuladoRespondidoEstatisticaDTO {
    private String simulado;
    private List<SimuladoRespondidoEstatisticaItemDTO> EstatisticasPorSimulados = new ArrayList<>();
    private List<SimuladoRespondidoEstatisticaModuloDTO> EstatisticasPorModulos = new ArrayList<>();

    public String getSimulado() {
        return simulado;
    }

    public List<SimuladoRespondidoEstatisticaModuloDTO> getEstatisticasPorModulos() {
        return EstatisticasPorModulos;
    }

    public void setEstatisticasPorModulos(List<SimuladoRespondidoEstatisticaModuloDTO> estatisticasPorModulos) {
        this.EstatisticasPorModulos = estatisticasPorModulos;
    }

    public List<SimuladoRespondidoEstatisticaItemDTO> getEstatisticasPorSimulados() {
		return EstatisticasPorSimulados;
	}

	public void setEstatisticasPorSimulados(List<SimuladoRespondidoEstatisticaItemDTO> estatisticasPorSimulados) {
		this.EstatisticasPorSimulados = estatisticasPorSimulados;
	}

	public void setSimulado(String simulado) {
        this.simulado = simulado;
    }

    public void addEstatisticasPorSimulado(SimuladoRespondidoEstatisticaItemDTO estatistica) {
        this.EstatisticasPorSimulados.add(estatistica);
    }

    public void addEstatisticaPorModulo(SimuladoRespondidoEstatisticaModuloDTO estatistica) {
        this.EstatisticasPorModulos.add(estatistica);
    }
}