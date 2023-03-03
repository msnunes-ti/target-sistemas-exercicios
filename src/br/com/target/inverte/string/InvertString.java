package br.com.target.inverte.string;

public class InvertString {

    public static String inverteString(String stringEntrada) {
        StringBuilder charList = new StringBuilder();
        charList.append(stringEntrada);
        StringBuilder stringInvertida = new StringBuilder();
        for(int i = stringEntrada.length() - 1; i >= 0; i--) {
            stringInvertida.append(charList.charAt(i));
        }
        return stringInvertida.toString();
    }
}
