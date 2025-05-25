package Exercicio3;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        lista.insere(1);
        lista.insere(3);
        lista.insere(7);
        lista.insere(9);
        lista.imprime();
        lista = lista.inverteLista();
        lista.imprime();
    }
}
