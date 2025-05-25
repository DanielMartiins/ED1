package Exercicio4;

public class ListaDuplamente {

    /* Refer�ncia para primeiro elemento */
    protected Elo prim;


//========= Daqui pra baixo � o que j� tinha na classe do professor =========


    public ListaDuplamente() {
        prim = null;
    }

    /* Resolu��o da quest�o 4 da lista auxiliar de Lista Encadeada. */
    public static ListaDuplamente concatena(ListaDuplamente l1, ListaDuplamente l2) {
        Elo p;

        /* Verifica se a lista l1 � vazia. */
        if (l1.prim == null) {
            l1.prim = l2.prim;
        } else {
            /* Primeiramente, precisamos obter o �ltimo elo da lista l1. */
            for (p = l1.prim; p.prox != null; p = p.prox) ;

            /* Faz o "prox" do �ltimo elemento da lista l1, apontado por "p",
             * apontar para o "prim" da lista l2. */
            p.prox = l2.prim;

            /* Faz o "ant" do "prim" da lista l2 apontar para o �ltimo elemento da
             * lista l1, apontado por "p". */
            l2.prim.ant = p;
        }

        /* Nesse ponto, os elementos de l2 j� est�o encadeados ao final de l1,
         * como desejado. Assim, vamos deixar a lista l2 vazia. */
        l2.prim = null;

        return l1;
    }

    /*
        Complexidade alcan�ada O(N) por conta do loop, que no pior caso vai
        ter que ir at� o ultimo elo da lista para encontrar o elo desejado.
     */
    public void trocaElos(int indiceElo1, int indiceElo2) {
        Elo elo1 = null, elo2 = null;
        int indice = 0;

        if (indiceElo1 == indiceElo2) return;
        else if (indiceElo1 > indiceElo2) {
            //Garantir que indice1 � menor que indice2
            int temp = indiceElo1;
            indiceElo1 = indiceElo2;
            indiceElo2 = temp;
        }

        //Buscar os elos em O(N), pois tenho que ir passando de elo em elo at� encontrar o que quero
        for (Elo p = prim; p != null; p = p.prox) {
            if (indice == indiceElo1) elo1 = p;
            else if (indice == indiceElo2) elo2 = p;
            indice++;
        }

        //Trocar os elos em O(1) mexendo apenas em ponteiros
        if (elo1 != null && elo2 != null) {
            Elo aux1 = new Elo(elo1.dado), aux2 = new Elo(elo2.dado);

            /*
             * Abaixo dei essas voltas para nao mexer no ponteiro criado nesse m�todo,
             * e sim realmente mexer no elo da lista
             */

            //Bloco de c�digo para substituir o primeiro elo pelo segundo
            //Vale lembrar que o primeiro elo � garantido que � o de menor ""indice"" pelo in�cio do m�todo
            if (elo1.ant != null) {
                aux2.ant = elo1.ant;
                aux2.ant.prox = aux2;
            } else prim = aux2;
            aux2.prox = elo1.prox;
            aux2.prox.ant = aux2;

            //Bloco de c�digo para substituir o segundo elo pelo primeiro
            //Vale lembrar que o segundo elo � garantido que � o de maior ""indice"" pelo inicio desse m�todo
            if (elo2.prox != null) {
                aux1.prox = elo2.prox;
                aux1.prox.ant = aux1;
            }
            aux1.ant = elo2.ant;
            aux1.ant.prox = aux1;
        }
    }

    /* Testa se a lista est� vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Insere elemento no in�cio da lista. */
    public void insere(int novo) {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    /* M�todo auxiliar para busca. */
    private Elo busca(int elem) {
        Elo p = null;

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox) ;

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public boolean remove(int elem) {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa se � ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;

        System.out.println("Elementos da lista:");

        for (p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Imprime todos os elementos da lista em ordem reversa. */
    public void imprimeReversa() {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa:");

        p = prim;

        while (p != null) {
            ult = p;
            p = p.prox;
        }

        for (p = ult; p != null; p = p.ant) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    protected class Elo {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo() {
            ant = null;
            prox = null;
        }

        public Elo(int elem) {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem) {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }
}