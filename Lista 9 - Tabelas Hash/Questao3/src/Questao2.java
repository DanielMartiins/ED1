import java.util.Random;
import java.util.Scanner;

public class Questao2 {
    private static final int M = 10; // O menor M possível é a quantidade das chaves que eu tenho
                              // Agora só preciso encontrar o valor de 'a'
    private static final char[][] tabelaHash = new char[M][1];
    private static final char[] chaves = {
            'S',
            'E',
            'A',
            'R',
            'C',
            'H',
            'X',
            'M',
            'P',
            'L'
    };
    public static void main(String[] args) {
        System.out.println(encontrarValorPerfeito());
    }

    private static double encontrarValorPerfeito() {
        int a;
        do {
            Random random = new Random();
            a = random.nextInt(0, 10000);
        } while (!encontrouHashPerfeito(Math.abs(a)));
        return a;
    }

    private static boolean encontrouHashPerfeito(int a) {
        for (char chave : chaves) {
            int k = chave - ('A' - 1);
            int valor_hash = (a * k) % M;
            if (tabelaHash[valor_hash] != null) return false;
            else tabelaHash[valor_hash][0] = chave;
        }
        return true;
    }
}