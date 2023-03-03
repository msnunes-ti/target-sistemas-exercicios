package br.com.target.fat.distribuidora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class FaturamentoDistribuidora {

    private HashMap<String, BigDecimal> faturamentoEstado = new HashMap<>();

    public static Double percentualEstado(BigDecimal valorEstado, BigDecimal valorTotal) {
        BigDecimal valor = valorEstado.multiply(BigDecimal.valueOf(100));
        return Double.parseDouble(String.valueOf(valor.divide(valorTotal, RoundingMode.HALF_DOWN)));
    }

    public HashMap<String, BigDecimal> getFaturamentoEstado() {
        return faturamentoEstado;
    }

    public void setFaturamentoEstado(HashMap<String, BigDecimal> faturamentoEstado) {
        this.faturamentoEstado = faturamentoEstado;
    }
}
