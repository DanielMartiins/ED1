package Exercicio5;

import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira frase");
        Frase frase = new Frase(scanner.nextLine());
        frase.inverterOrdemEPalavras();
        frase.imprime();
    }
}
