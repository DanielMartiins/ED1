package Exercicio3;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PilhaDupla pilhaDupla = new PilhaDupla(3, 10);

        pilhaDupla.pushFirst('1');
        pilhaDupla.pushFirst('2');
        pilhaDupla.pushFirst('3');
        pilhaDupla.pushFirst('4'); //Esse push não vai funcionar porque vai tar cheio
        pilhaDupla.pushSecond('a');
        pilhaDupla.pushSecond('b');
        pilhaDupla.pushSecond('b');
        pilhaDupla.pushSecond('b');
        pilhaDupla.pushSecond('b');
        pilhaDupla.pushSecond('b');
        pilhaDupla.pushSecond('d');
        pilhaDupla.pushSecond('d');
        pilhaDupla.pushSecond('d');
        pilhaDupla.pushSecond('d');
        pilhaDupla.pushSecond('f'); //Esse push nao vai funcionar porque vai tar cheio

        pilhaDupla.popSecond();
        pilhaDupla.pushSecond('g'); //Agora vai funcionar

        System.out.println();
    }
}