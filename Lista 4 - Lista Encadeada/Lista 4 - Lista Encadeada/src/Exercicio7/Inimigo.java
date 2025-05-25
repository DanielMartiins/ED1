package Exercicio7;

import java.util.Objects;

public class Inimigo {
    private int vida;
    private double danoPorSegundo;

    /*
    Todos os getters e setters abaixo são O(1)
     */
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDanoPorSegundo() {
        return danoPorSegundo;
    }

    public void setDanoPorSegundo(double danoPorSegundo) {
        this.danoPorSegundo = danoPorSegundo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inimigo inimigo = (Inimigo) o;
        return vida == inimigo.vida && Double.compare(danoPorSegundo, inimigo.danoPorSegundo) == 0;
    }
}
