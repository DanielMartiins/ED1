package Exercicio1;

/*
    Tirei os métodos que não eram relevantes para o exercício, para melhorar a leitura na correção.
    Criei um atributo 'tamanho' e modifiquei os métodos remove(), insere() e tamanho().
    No fim, retornar o tamanho da lista ficou em O(1), pois eu simplesmente acesso o valor da variável 'tamanho'.

 */
public class ListaEx1 {

    /* Referência para primeiro elemento */
    protected Elo prim;
    int tamanho;

    protected class Elo {
        protected int dado;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(int elem) {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo proxElem) {
            dado = elem;
            prox = proxElem;
        }
    }

    public ListaEx1() {
        prim = null;
        tamanho = 0;
    }

    /* Insere elemento no início da lista. */
    public void insere(int novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
        tamanho++;
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(int elem) {
        Elo p;
        Elo ant = null; /* Referência para anterior. */

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;

        /* Se p é null, então não encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do início. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */
        tamanho--;

        /* Remove a última referência para o elo a ser removido. Dessa forma,
         * o Garbage Collector irá liberar essa memória. */
        p = null;

        return true;
    }

    //Agora o método só retorna o tamanho da lista, diretamente.
    //Portanto, a complexidade fica em O(1).
    public int tamanho() {
        return tamanho;
    }
}