package br.com.target.fat.distribuidora;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FaturamentoDistribuidoraService {

    public static void main(String[] args) {

        HashMap<String, BigDecimal> entradaDados = new HashMap<>();
        entradaDados.put("SP", BigDecimal.valueOf(67836.43));
        entradaDados.put("RJ", BigDecimal.valueOf(36678.66));
        entradaDados.put("MG", BigDecimal.valueOf(29229.88));
        entradaDados.put("ES", BigDecimal.valueOf(27165.48));
        entradaDados.put("Outros", BigDecimal.valueOf(19849.53));

        FaturamentoDistribuidora faturamentoDistribuidora = new FaturamentoDistribuidora();
        faturamentoDistribuidora.setFaturamentoEstado(entradaDados);

        BigDecimal valorTotalMensal = faturamentoDistribuidora.getFaturamentoEstado().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nO faturamento total (mensal) da Distribuidora foi de R$ %.2f.\n\n", valorTotalMensal);

        for(Map.Entry<String, BigDecimal> f: faturamentoDistribuidora.getFaturamentoEstado().entrySet()) {
            System.out.printf("O estado %s têm o percentual de %.2f do total.\n",f.getKey() ,FaturamentoDistribuidora.percentualEstado(f.getValue(), valorTotalMensal));
        }
        System.out.println();
    }
}
