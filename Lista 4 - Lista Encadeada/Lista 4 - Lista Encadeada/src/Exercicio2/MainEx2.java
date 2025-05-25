package Exercicio2;

public class MainEx2 {

    public static void main(String[] args) {
        ListaOrdenada listaA = new ListaOrdenada(), listaB = new ListaOrdenada();
        for (int i = 1; i <= 10; i++) listaA.insere(i);
        for (int i = 1; i <= 10; i++) listaB.insere(i * 11);

        ListaIntercalada listaIntercalada = new ListaIntercalada(listaA, listaB);
        listaIntercalada.imprime();
    }

    public static void a()
    {
        ListaOrdenada listaA = new ListaOrdenada(), listaB = new ListaOrdenada();
        ListaIntercalada listaIntercalada = new ListaIntercalada(listaA, listaB);
    }


    private static class ListaIntercalada extends ListaOrdenada {

        public ListaIntercalada(ListaOrdenada listaA, ListaOrdenada listaB) {
            intercalarDuasListas(listaA, listaB);
        }

        private void intercalarDuasListas(ListaOrdenada listaA, ListaOrdenada listaB) {
            Elo p, q;

            for (p = listaA.prim, q = listaB.prim; p != null && q != null; p = p.prox, q = q.prox) {
                this.insere(p.dado);
                this.insere(q.dado);
            }
        }
    }
}
