package Exercicio5;

public class Main {
    public static void main(String[] args) {
        ArvBinBusca<Integer, Integer> arv = new ArvBinBusca<>();

        arv.put(5,5);
        arv.put(7,7);
        arv.put(11,11);
        arv.put(10,10);
        arv.put(3,3);
        arv.put(4,4);
        arv.put(2,2);

        System.out.println(arv.obtemAncestralComum(1,3));
    }
}
