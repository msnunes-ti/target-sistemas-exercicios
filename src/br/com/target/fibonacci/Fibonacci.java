package br.com.target.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    static long fibo(int n) {
        return (n < 2) ? n : fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("\nDigite um número para verificar se pertence a sequência Fibonacci: ");
        long verificar = entrada.nextLong();
        int indice = 0;
        boolean controle = true;
        long sequencia;

        while (controle) {
            sequencia = Fibonacci.fibo(indice);
            indice++;
            if(sequencia == verificar) {
                controle = false;
                System.out.printf("O número %d pertence a sequência de fibonacci.\n\n", verificar);
            }
            if(sequencia > verificar) {
                controle = false;
                System.out.printf("O número %d não pertence a sequência de fibonacci.\n\n", verificar);
            }
        }
    }
}
