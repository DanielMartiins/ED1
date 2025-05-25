package Exercicio4;

import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira alguma frase");
        String str = scanner.nextLine();
        scanner.close();
        Frase frase = new Frase(str);
        frase.imprime();
    }
}
