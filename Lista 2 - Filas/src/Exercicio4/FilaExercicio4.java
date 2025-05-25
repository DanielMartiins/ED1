package Exercicio4;

import filaCircularDupla.FilaDupla;
import filaCircularSimples.Fila;

public class FilaExercicio4 extends Fila {
    public FilaExercicio4(int tam) {
        super(tam);
    }

    public static FilaDupla converterParaFilaCircularDupla(Fila filaSimples) {
        FilaDupla filaCircularDupla = new FilaDupla(filaSimples.getTamanho());
        while (!filaSimples.vazia()) {
            filaCircularDupla.insere(filaSimples.remove());
        }
        return filaCircularDupla;
    }
}
