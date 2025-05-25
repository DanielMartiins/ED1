package Exercicio2;

public class ArvBinBuscaInteiro extends ArvBinBusca<Integer, Integer> {

    //Assumindo árvore binaria de busca inicialmente vazia, como foi informado que poderia fazer
    /*
        Complexidade O(N²)
        Motivo: Vou percorrer o vetor, de tamanho N. E a cada i-ésimo elemento do vetor chamo o
        método put(). Put() no pior caso possui complexidade O(N) também, pois a árvore inteira
        pode estar à esquerda ou à direita da raiz e o local de inserção pode estar após uma folha.
        Sendo assim, complexidade fica como O(N*N) = O(N²)
     */
    public void constroiArvore(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) put(i, vetor[i]);
    }
}
