package Exercicio1;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaOperacional SO = new SistemaOperacional(10);

    public static void main(String[] args) {

        int opcao = 9999;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            executarOpcao(opcao);
        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("==============================================================");
        System.out.println("1) Incluir um novo processo");
        System.out.println("2) Retirar da fila o processo com maior tempo de espera");
        System.out.println("3) Imprimir conteudo da fila de processos");
        System.out.println("0) Sair");
        System.out.println("==============================================================");
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> {
                System.out.println("Numero ID do processo: ");
                if (SO.incluirProcesso(new Processo(scanner.nextInt())))
                    System.out.println("Processo incluido com sucesso");
                else
                    System.out.println("Falha em incluir o processo(fila cheia)");
            }
            case 2 -> {
                if (SO.retirarProcessoComMaiorTempoDeEspera())
                    System.out.println("Foi removido o processo com maior tempo de espera");
                else
                    System.out.println("Não há processos no sistema para ser removido");
            }
            case 3 -> {
                if (!SO.imprimirProcessos())
                    System.out.println("Não há processos no sistema para ser impresso.");
            }
        }
    }
}
