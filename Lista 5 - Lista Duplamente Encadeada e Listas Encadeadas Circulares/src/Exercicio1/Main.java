package Exercicio1;

public class Main extends ListaDuplamente {

    public static ListaDuplamente interseccionarListas(ListaDuplamente L1,
                                                       ListaDuplamente L2) {
        /*
            Complexidade computacional alcançada: Dado 'N' a quantidade de elos
        de uma lista e 'N' o tamanho de outra, a complexidade é de O(N^2). A cada
        iteração do primeiro loop, no pior caso eu passo por todos os elementos
        da segunda lista.
        */

        ListaDuplamente L3 = new ListaDuplamente();

        for (Elo p1 = L1.prim; p1.prox != null; p1 = p1.prox) {
            for (Elo p2 = L2.prim; p2.prox != null; p2 = p2.prox)
                if (p1.dado == p2.dado) L3.insere(p2.dado);
        }

        return L3;
    }
}
