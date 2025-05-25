/*
Basicamente criei um atributo qtdNumerosPares que � incrementado ao usar push() para um elemento par,
e tamb�m decrementado ao usar o pop() para remover um elemento par. Assim, consigo a melhor complexidade possível,
que seria O(1).
 */

public class Pilha {
    private final int[] vetor;
    private int n;
    private int topo;
    private int qtdNumerosPares;

    public Pilha() {
        n = 10;
        vetor = new int[n];
        topo = -1;
        qtdNumerosPares = 0;
    }

    public Pilha(int tamanho) {
        n = tamanho;
        vetor = new int[tamanho];
        topo = -1;
        qtdNumerosPares = 0;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == n - 1;
    }

    public int pop() {
        int c = '\0';

        if (!this.vazia()) {
            c = vetor[topo];
            if (c % 2 == 0)
                qtdNumerosPares--;
            //Decrementando o topo, o elemento � "removido"
            topo--;
        } else
            System.out.println("Pilha vazia: pop n�o funcionou.");

        return c;
    }

    public boolean push(int elemento) {
        if (!this.cheia()) {
            vetor[++topo] = elemento;
            if (elemento % 2 == 0)
                qtdNumerosPares++;
            return true;
        } else {
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public int retornaTopo() {
        int elemento = '\0';

        if (!this.vazia())
            elemento = vetor[topo];
        else
            System.out.println("Pilha vazia.");

        return elemento;
    }

    public int getQtdNumerosPares() {
        return qtdNumerosPares;
    }
}