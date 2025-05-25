package Exercicio4;

public class Main {
    public static void main(String[] args) {
        ListaDuplamente lista = new ListaDuplamente();
        lista.insere(1);
        lista.insere(3);
        lista.imprime();
        lista.trocaElos(1,0);
        lista.imprime();
    }
}
