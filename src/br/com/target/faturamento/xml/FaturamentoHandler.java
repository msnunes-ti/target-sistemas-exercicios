package br.com.target.faturamento.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;

public class FaturamentoHandler extends DefaultHandler {

    private FaturamentoMensal faturamentoMensal;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        faturamentoMensal = new FaturamentoMensal();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case "row":
                faturamentoMensal.getFaturamentos().add(new Faturamento());
                break;
            case "dia":
                elementValue = new StringBuilder();
                break;
            case "valor":
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "dia":
                ultimoFaturamento().setDia(Integer.valueOf(elementValue.toString()));
                break;
            case "valor":
                ultimoFaturamento().setValor(BigDecimal.valueOf(Double.parseDouble(elementValue.toString())));
                break;
        }
    }

    private Faturamento ultimoFaturamento() {
        int ultimoIndice = faturamentoMensal.getFaturamentos().size() - 1;
        return faturamentoMensal.getFaturamentos().get(ultimoIndice);
    }

    public FaturamentoMensal getFaturamentoMensal() {
        return faturamentoMensal;
    }
}
