package Exercicio3;

import java.util.Objects;

/*
 * Não entendi o exercício, é para usar generics mas quer que façamos manipulação com string especificamente.
 * Então eu preciso usar String, não um tipo genérico, se não vou ter erros ou warnings envolvendo tipos, já
 * na IDE. Fiz pelo menos a ListaGenerica, usando Generics, para mostrar como eu faria uma lista generica.
 */

public class ListaOrdenada extends ListaGenerica<String> {

    public void insere(String novo) {
        /* Complexidade: O(N^2). Para cada elemento da minha lista encadeada, de 0 a N,
         * eu vou chamar o método "precede", que possui complexidade O(N). Logo, O(N^2). */
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
        /* Complexidade: O(N), pois o método compareTo() do java possui complexidade O(N).
         * acredito que esse método deve passar por cada caracter para realizar a comparação.
         */
        return paraInserir.compareTo(paraSerSubstituido) <= 0;
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    /*
    public boolean remove(String elem) {
        Elo p;
        Elo ant = null; // referência para anterior

        for (p = prim; ((p != null) && (precede(elem, p.dado))); p = p.prox)
            ant = p;

       Se p é null ou p.dado != elem, então não encontrou elemento.
        if ((p == null) || (!Objects.equals(p.dado, elem)))
            return false;

        if (p == prim)
            prim = prim.prox; // Remove elemento do início.
        else
            ant.prox = p.prox;  // Remove elemento do meio.

         * Remove a última referência para o elo a ser removido. Dessa forma,
         * o Garbage Collector irá liberar essa memória.
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