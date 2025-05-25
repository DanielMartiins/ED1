public class Exercicio4 {

    public static void main(String[] args) {
        PilhaGenerica<Object> pilha = new PilhaGenerica<>(5);
        pilha.push('a');
        pilha.push('b');
        pilha.push('c');
        pilha.push('d');
        pilha.push('e');
        if (removerObjetoDaPilha(pilha, 5, 'c'))
            System.out.println("Conseguiu remover");
        else
            System.out.println("Não conseguiu remover");

    }

    public static boolean removerObjetoDaPilha(PilhaGenerica<Object> pilha, int tamanhoPilha,
                                               Object objetoParaRemover) {

        PilhaGenerica<Object> pilhaAuxiliar = new PilhaGenerica<>(tamanhoPilha);
        boolean encontrou = false;

        while (!pilha.vazia()) {
            Object objeto = pilha.pop();
            if (objeto.equals(objetoParaRemover))
                encontrou = true;
            else
                pilhaAuxiliar.push(objeto);
        }

        while (!pilhaAuxiliar.vazia()) {
            pilha.push(pilhaAuxiliar.pop());
        }

        return encontrou;
    }
}
