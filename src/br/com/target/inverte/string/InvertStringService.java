package br.com.target.inverte.string;

import java.util.Scanner;

public class InvertStringService {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("\nDigite uma String para inverter: ");
        String stringEntrada = entrada.nextLine();
        System.out.printf("String invertida: %s.\n\n", InvertString.inverteString(stringEntrada));
    }
}
