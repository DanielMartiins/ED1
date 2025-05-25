package Exercicio5;

public class Frase extends ListaGenerica<Character> {

    public Frase(String str) {
        montarFraseNaListaEncadeada(str);
    }

    /* Complexidade O(N), percorrer do N-�simo ao primeiro caracter da string.
     * Percorro ao contr�rio para n�o ficar invertido na instancia de FraseEx5,
     * j� que a princ�pio ela ainda representa uma frase simplesmente. Se eu quiser
     * inverter chamo o m�todo inverterOrdemEPalavras()
     */
    private void montarFraseNaListaEncadeada(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            this.insere(str.charAt(i));
        }
    }

    //Complexidade O(N). Percorro do primeiro Elo ao �ltimo e fa�o opera��es que s�o O(1).
    public void inverterOrdemEPalavras() {
        ListaGenerica<Character> listaAuxiliar = new ListaGenerica<>();

        for (Elo p = prim; p != null; p = p.prox) {
            listaAuxiliar.insere(p.dado);
        }

        this.prim = listaAuxiliar.prim;
    }

    //Complexidade O(N). Novamente percorrer do primeiro ao �ltimo Elo e simplesmente imprimir.
    public void imprime() {
        for (Elo p = prim; p != null; p = p.prox) {
            System.out.print(p.dado);
        }
        System.out.println();
    }
}
