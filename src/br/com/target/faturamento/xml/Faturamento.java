package br.com.target.faturamento.xml;

import java.math.BigDecimal;

public class Faturamento {

    private Integer dia;
    private BigDecimal valor;

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
