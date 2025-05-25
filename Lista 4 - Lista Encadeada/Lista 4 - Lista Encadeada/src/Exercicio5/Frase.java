package Exercicio5;

public class Frase extends ListaGenerica<Character> {

    public Frase(String str) {
        montarFraseNaListaEncadeada(str);
    }

    /* Complexidade O(N), percorrer do N-ésimo ao primeiro caracter da string.
     * Percorro ao contrário para não ficar invertido na instancia de FraseEx5,
     * já que a princípio ela ainda representa uma frase simplesmente. Se eu quiser
     * inverter chamo o método inverterOrdemEPalavras()
     */
    private void montarFraseNaListaEncadeada(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            this.insere(str.charAt(i));
        }
    }

    //Complexidade O(N). Percorro do primeiro Elo ao último e faço operações que são O(1).
    public void inverterOrdemEPalavras() {
        ListaGenerica<Character> listaAuxiliar = new ListaGenerica<>();

        for (Elo p = prim; p != null; p = p.prox) {
            listaAuxiliar.insere(p.dado);
        }

        this.prim = listaAuxiliar.prim;
    }

    //Complexidade O(N). Novamente percorrer do primeiro ao último Elo e simplesmente imprimir.
    public void imprime() {
        for (Elo p = prim; p != null; p = p.prox) {
            System.out.print(p.dado);
        }
        System.out.println();
    }
}
