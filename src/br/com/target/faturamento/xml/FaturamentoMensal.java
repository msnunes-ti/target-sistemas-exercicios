package br.com.target.faturamento.xml;

import java.util.ArrayList;
import java.util.List;

public class FaturamentoMensal {

    private List<Faturamento> faturamentos = new ArrayList<>();

    public List<Faturamento> getFaturamentos() {
        return faturamentos;
    }

    public void setFaturamentos(List<Faturamento> faturamentos) {
        this.faturamentos = faturamentos;
    }
}
