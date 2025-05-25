package Exercicio5;

public class Main {
    public static void main(String[] args) {
        /*
        int[] vetor = new int[6];

        vetor[0] = 30;
        vetor[1] = 20;
        vetor[2] = 15;
        vetor[3] = 18;
        vetor[4] = 17;
        vetor[5] = 13;
        HeapBinariaMaxima h = new HeapBinariaMaxima(6, vetor);
        h.imprime();
        h.remove(4);
        h.imprime();
        h.remove(1);
        h.imprime();*/

        int[] vetor = {22,4,35,12,3,18,12,55};
        HeapBinariaMaxima h = new HeapBinariaMaxima(8, vetor);
        h.imprime();

    }
}
