package Exercicio5;

public class Main {
    public static void main(String[] args) {
        ListaDuplamente lista = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();
        /*
        lista.insere(1);
        lista.insere(3);
        lista2.insere(1);
        lista2.insere(3);
        lista2.insere(3);

         */

        if (lista.verificaIgualdade(lista2)) System.out.println("isso");
    }
}
