package Exercicio2;

import filaCircularSimples.Fila;

public class FilaExercicio2 extends Fila {

    public FilaExercicio2(int tam) {
        super(tam);
    }

    public void combinaFilas(Fila f1, Fila f2) {
        while (!(f1.vazia() && f2.vazia())) {
            insere(f1.remove());
            insere(f2.remove());
        }
    }
}
