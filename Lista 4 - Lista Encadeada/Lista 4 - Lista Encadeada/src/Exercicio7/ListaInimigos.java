package Exercicio7;

public class ListaInimigos extends ListaGenerica<Inimigo> {

    /*
     * N�o coloquei inserir() porque o m�todo insere() da classe
     * ListaGenerica j� faz exatamente o que o exerc�cio quer
     */

    //Complexidade O(N): No pior caso o inimigo est� no N-�simo elo
    public Inimigo localizar(Inimigo inimigo) {
        Elo p;

        for (p = prim; p != null; p = p.prox) {
            if (p.dado.equals(inimigo))
                return p.dado;
        }
        return null;
    }

    /* Complexidade O(N) por conta do uso de localizar() e remove(), que ambos
     * possuem complexidade O(N) e cada um � utilizado uma �nica vez */
    public int efetuarDano(Inimigo inimigo, double dano) {
        Inimigo i = localizar(inimigo);

        if (i == null) return Integer.MIN_VALUE; //N�o encontrou

        int vidaRestante = (int) (i.getVida() - dano);
        i.setVida(vidaRestante);
        if (i.getVida() <= 0) remove(i);

        return vidaRestante;
    }
}