package Exercicio3;

public class PilhaDupla {


    private final int tamanhoFirst;
    private final int tamanhoSecond;
    private final char[] vetor;
    private int topoFirst;
    private int topoSecond;


    public PilhaDupla() {
        tamanhoFirst = 10;
        tamanhoSecond = 10;
        vetor = new char[tamanhoFirst + tamanhoSecond];
        topoFirst = -1;
        topoSecond = tamanhoFirst;
    }

    public PilhaDupla(int tamanhoFirst, int tamanhoSecond) {
        this.tamanhoFirst = tamanhoFirst;
        this.tamanhoSecond = tamanhoSecond;
        vetor = new char[tamanhoFirst + tamanhoSecond];
        topoFirst = -1;
        topoSecond = tamanhoFirst - 1;
    }

    public boolean vaziaFirst() {
        return topoFirst == -1;
    }

    public boolean vaziaSecond() {
        return topoSecond == tamanhoFirst - 1;
    }

    public boolean cheiaFirst() {
        return topoFirst == tamanhoFirst - 1;
    }

    public boolean cheiaSecond() {
        return topoSecond == tamanhoFirst + tamanhoSecond - 1;
    }

    public char popFirst() {
        char c = '\0';

        if (!this.vaziaFirst()) {
            c = vetor[topoFirst];

            //Decrementando o topo, o elemento � "removido"
            topoFirst--;
        } else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }

        return c;
    }

    public char popSecond() {
        char c = '\0';

        if (!this.vaziaSecond()) {
            c = vetor[topoSecond];

            //Decrementando o topo, o elemento � "removido"
            topoSecond--;
        } else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }

        return c;
    }

    public boolean pushFirst(char elemento) {
        if (!this.cheiaFirst()) {
            vetor[++topoFirst] = elemento;
            return true;
        } else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public boolean pushSecond(char elemento) {
        if (!this.cheiaSecond()) {
            vetor[++topoSecond] = elemento;
            return true;
        } else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public char retornaTopoFirst() {
        char elemento = '\0';

        if (!this.vaziaFirst()) {
            elemento = vetor[topoFirst];
        } else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public char retornaTopoSecond() {
        char elemento = '\0';

        if (!this.vaziaSecond()) {
            elemento = vetor[topoSecond];
        } else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }
}

