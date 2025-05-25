package Exercicio2;

import filaCircularSimples.Fila;

public class Main {

    public static void main(String[] args) {
        //O método combinaFilas() se encontra na classe FilaExercicio2
        FilaExercicio2 filaMista = new FilaExercicio2(10);
        Fila f1 = new Fila(5);
        Fila f2 = new Fila(5);

        for (int i = 1; i <= 5; i++){
            f1.insere(i);
            f2.insere(i*10);
        }

        filaMista.combinaFilas(f1,f2);
        System.out.println();
    }
}
