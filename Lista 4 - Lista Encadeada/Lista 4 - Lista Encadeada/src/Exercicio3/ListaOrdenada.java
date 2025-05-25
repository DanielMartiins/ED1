package Exercicio3;

import java.util.Objects;

/*
 * N�o entendi o exerc�cio, � para usar generics mas quer que fa�amos manipula��o com string especificamente.
 * Ent�o eu preciso usar String, n�o um tipo gen�rico, se n�o vou ter erros ou warnings envolvendo tipos, j�
 * na IDE. Fiz pelo menos a ListaGenerica, usando Generics, para mostrar como eu faria uma lista generica.
 */

public class ListaOrdenada extends ListaGenerica<String> {

    public void insere(String novo) {
        /* Complexidade: O(N^2). Para cada elemento da minha lista encadeada, de 0 a N,
         * eu vou chamar o m�todo "precede", que possui complexidade O(N). Logo, O(N^2). */
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);
        for (p = prim; ((p != null) && (precede(novo, p.dado))); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
    }

    private boolean precede(String paraInserir, String paraSerSubstituido) {
        /* Complexidade: O(N), pois o m�todo compareTo() do java possui complexidade O(N).
         * acredito que esse m�todo deve passar por cada caracter para realizar a compara��o.
         */
        return paraInserir.compareTo(paraSerSubstituido) <= 0;
    }

    /* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
    /*
    public boolean remove(String elem) {
        Elo p;
        Elo ant = null; // refer�ncia para anterior

        for (p = prim; ((p != null) && (precede(elem, p.dado))); p = p.prox)
            ant = p;

       Se p � null ou p.dado != elem, ent�o n�o encontrou elemento.
        if ((p == null) || (!Objects.equals(p.dado, elem)))
            return false;

        if (p == prim)
            prim = prim.prox; // Remove elemento do in�cio.
        else
            ant.prox = p.prox;  // Remove elemento do meio.

         * Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
         * o Garbage Collector ir� liberar essa mem�ria.
        p = null;

        return true;
    }
    */

    public boolean remove(String elem)
    {
        if (this.vazia()) return false;

        Elo p;
        Elo ant = null;

        for (p = prim; p != null && !Objects.equals(elem, p.dado); p = p.prox)
            ant = p;

        if (p == null || !Objects.equals(p.dado, elem)) return false;

        if (p == prim)
            prim = p.prox;
        else
            ant.prox = p.prox;

        return true;
    }
}