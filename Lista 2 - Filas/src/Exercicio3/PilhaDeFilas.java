package Exercicio3;

import filaCircularSimples.Fila;

public class PilhaDeFilas {
    private int n;
    private final Fila[] vetor;
    private int topo;

    public PilhaDeFilas() {
        n = 10;
        vetor = new Fila[n];
        topo = -1;
    }

    public PilhaDeFilas(int tamanho) {
        n = tamanho;
        vetor = new Fila[tamanho];
        topo = -1;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == n - 1;
    }

    public Fila pop() {
        Fila c = null;

        if (!this.vazia()) {
            c = vetor[topo];

            //Decrementando o topo, o elemento é "removido"
            topo--;
        } else {
            //Impressão para fins didáticos
            System.out.println("Exercicio3.Pilha vazia: pop não funcionou.");
        }

        return c;
    }

    public boolean push(Fila elemento) {
        if (!this.cheia()) {
            vetor[++topo] = elemento;
            return true;
        } else {
            //Impressão para fins didáticos
            System.out.println("Exercicio3.Pilha cheia: push não funcionou.\n");
            return false;
        }
    }

    public Fila retornaTopo() {
        Fila elemento = null;

        if (!this.vazia()) {
            elemento = vetor[topo];
        } else {
            System.out.println("Exercicio3.Pilha vazia.");
        }

        return elemento;
    }
}
