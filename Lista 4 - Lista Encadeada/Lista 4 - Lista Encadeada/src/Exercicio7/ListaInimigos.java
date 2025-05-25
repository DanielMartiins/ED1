package Exercicio7;

public class ListaInimigos extends ListaGenerica<Inimigo> {

    /*
     * Não coloquei inserir() porque o método insere() da classe
     * ListaGenerica já faz exatamente o que o exercício quer
     */

    //Complexidade O(N): No pior caso o inimigo está no N-ésimo elo
    public Inimigo localizar(Inimigo inimigo) {
        Elo p;

        for (p = prim; p != null; p = p.prox) {
            if (p.dado.equals(inimigo))
                return p.dado;
        }
        return null;
    }

    /* Complexidade O(N) por conta do uso de localizar() e remove(), que ambos
     * possuem complexidade O(N) e cada um é utilizado uma única vez */
    public int efetuarDano(Inimigo inimigo, double dano) {
        Inimigo i = localizar(inimigo);

        if (i == null) return Integer.MIN_VALUE; //Não encontrou

        int vidaRestante = (int) (i.getVida() - dano);
        i.setVida(vidaRestante);
        if (i.getVida() <= 0) remove(i);

        return vidaRestante;
    }
}