package br.com.formula.bancaria.api.dto.simuladoRespondido;

public class SimuladoRespondidoEstatisticaModuloDTO {
    private String modulo;
    private double percentualAcertos;

    public String getModulo() {
        return modulo;
    }

    public double getPercentualAcertos() {
        return Math.round(percentualAcertos);
    }

    public void setPercentualAcertos(double percentualAcertos) {
        this.percentualAcertos = percentualAcertos;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}