package Exercicio5;

import filaCircularSimples.Fila;

public class Main {
    public static void main(String[] args) {

        Fila numeroDecimalSeparadoPorDigitos = new Fila(90);
        numeroDecimalSeparadoPorDigitos.insere(7);
        numeroDecimalSeparadoPorDigitos.insere(2);

        System.out.println(converterParaBinario(numeroDecimalSeparadoPorDigitos));
    }

    public static String converterParaBinario(Fila numeroDecimalSeparadoPorDigitos) {

        int resto = 0;
        int digito;
        StringBuilder resultadoDivisao = new StringBuilder();
        StringBuilder numeroBinario = new StringBuilder();

        do {
            digito = (resto * 10) + numeroDecimalSeparadoPorDigitos.remove();
            resto = digito % 2;
            resultadoDivisao.append(digito / 2);
            numeroBinario.append(resto);
        } while (!numeroDecimalSeparadoPorDigitos.vazia());

        int numero;
        do {
            numero = Integer.parseInt(String.valueOf(resultadoDivisao));
            resto = numero % 2;
            numeroBinario.append(resto);
            resultadoDivisao = new StringBuilder(String.valueOf(numero/2));
        } while (numero >= 2);

        return String.valueOf(numeroBinario);
    }

    public static void realizarCalculos (Integer resto,
                                         StringBuilder resultadoDivisao, StringBuilder numeroBinario,
                                         Fila numeroDecimalSeparadoPorDigitos) {
        do {
            int digito = (resto * 10) + numeroDecimalSeparadoPorDigitos.remove();
            resto = digito % 2;
            resultadoDivisao.append(digito / 2);
            numeroBinario.append(resto);
        } while(!numeroDecimalSeparadoPorDigitos.vazia());
    }
}
