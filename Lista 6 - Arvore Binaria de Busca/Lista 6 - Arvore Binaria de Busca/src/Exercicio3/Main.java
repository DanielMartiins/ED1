package Exercicio3;


import Exercicio3.ArvBinBusca;

public class Main {
    public static void main(String[] args) {
        ArvBinBusca<Integer, Integer> a = new ArvBinBusca<>();
        ArvBinBusca<Integer, Integer> b = new ArvBinBusca<>();

        a.put(2, 2);
        a.put(-5, -5);
        a.put(-3, -3);
        a.put(-7, -7);
        a.put(5, 5);
        a.put(55, 55);

        b.put(2, 2);
        b.put(-5, -5);
        b.put(-3, -3);
        b.put(-7, -7);
        b.put(5, 5);
        b.put(55, 55);
        // b.put(56, 56); //retorna falso se adicionar essa linha comentada de volta, acredito que faz sentido

        boolean teste = a.eSimilar(b);
        System.out.println(teste);
    }
}
