package br.com.target.faturamento.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FaturamentoService {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        FaturamentoHandler faturamentoHandler = new FaturamentoHandler();
        List<InputStream> streams = Arrays.asList(
                new ByteArrayInputStream("<root>".getBytes()),
                new FileInputStream("dados.xml"),
                new ByteArrayInputStream("</root>".getBytes())
        );
        InputStream is = new SequenceInputStream(Collections.enumeration(streams));
        saxParser.parse(is, faturamentoHandler);
        System.out.println("\nValores obtidos do arquivo (dados.xml).");
        faturamentoHandler.getFaturamentoMensal().getFaturamentos().forEach((f) -> System.out.println(f.getValor().toString()));

        BigDecimal menorFaturamento = faturamentoHandler.getFaturamentoMensal().getFaturamentos().stream()
                .map(Faturamento::getValor)
                .filter(valor -> BigDecimal.ZERO.compareTo(valor) < 0)
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
        BigDecimal maiorFaturamento = faturamentoHandler.getFaturamentoMensal().getFaturamentos().stream()
                .map(Faturamento::getValor)
                .filter(valor -> BigDecimal.ZERO.compareTo(valor) < 0)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
        BigDecimal totalFaturamentoMensal = faturamentoHandler.getFaturamentoMensal().getFaturamentos().stream()
                .map(Faturamento::getValor)
                .filter(valor -> BigDecimal.ZERO.compareTo(valor) < 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        long diasComFaturamento = faturamentoHandler.getFaturamentoMensal().getFaturamentos().stream()
                .filter(f -> BigDecimal.ZERO.compareTo(f.getValor()) < 0)
                .count();
        BigDecimal mediaFaturamento = totalFaturamentoMensal.divide(BigDecimal.valueOf(diasComFaturamento), 2, RoundingMode.HALF_DOWN);
        List<Faturamento> diasComFaturamentoAcimaMedia = faturamentoHandler.getFaturamentoMensal().getFaturamentos().stream()
                .filter(f -> f.getValor().compareTo(mediaFaturamento) > 0)
                .toList();
        System.out.println("\nValores trabalhados:");
        System.out.printf("O menor valor de faturamento do mês foi R$ %.2f.\n", menorFaturamento);
        System.out.printf("O maior valor de faturamento do mês foi R$ %.2f.\n", maiorFaturamento);
        System.out.printf("O valor médio de faturamento do mês foi R$ %.2f.\n", mediaFaturamento);
        System.out.println("\nDias com faturamento acima da média:");
        diasComFaturamentoAcimaMedia.forEach(f -> System.out.printf("Dia: %d, Valor R$ %.2f.\n", f.getDia(), f.getValor()));
        System.out.println();
    }
}
