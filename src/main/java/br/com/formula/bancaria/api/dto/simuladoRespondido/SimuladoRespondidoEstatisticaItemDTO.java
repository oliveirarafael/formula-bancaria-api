package br.com.formula.bancaria.api.dto.simuladoRespondido;

import java.time.LocalDateTime;

public class SimuladoRespondidoEstatisticaItemDTO {
    private LocalDateTime data;
    private Double percentualAcertos;

    public LocalDateTime getData() {
        return data;
    }

    public Double getPercentualAcertos() {
        return percentualAcertos;
    }

    public void setPercentualAcertos(Double percentualAcertos) {
        this.percentualAcertos = percentualAcertos;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}