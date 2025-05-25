package Exercicio1;

/*
    Tirei os m�todos que n�o eram relevantes para o exerc�cio, para melhorar a leitura na corre��o.
    Criei um atributo 'tamanho' e modifiquei os m�todos remove(), insere() e tamanho().
    No fim, retornar o tamanho da lista ficou em O(1), pois eu simplesmente acesso o valor da vari�vel 'tamanho'.

 */
public class ListaEx1 {

    /* Refer�ncia para primeiro elemento */
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

    /* Insere elemento no in�cio da lista. */
    public void insere(int novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
        tamanho++;
    }

    /* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
    public boolean remove(int elem) {
        Elo p;
        Elo ant = null; /* Refer�ncia para anterior. */

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;

        /* Se p � null, ent�o n�o encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do in�cio. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */
        tamanho--;

        /* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
         * o Garbage Collector ir� liberar essa mem�ria. */
        p = null;

        return true;
    }

    //Agora o m�todo s� retorna o tamanho da lista, diretamente.
    //Portanto, a complexidade fica em O(1).
    public int tamanho() {
        return tamanho;
    }
}