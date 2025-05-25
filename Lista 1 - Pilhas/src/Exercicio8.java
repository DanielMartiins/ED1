import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio8 {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String string = scanner.nextLine();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            char n = string.charAt(i);

            if (n != ' ')
                array.add(Integer.parseInt(String.valueOf(n)));
        }

        System.out.printf("%d par(es)", quantidadePares(array));
    }

    public static int quantidadePares(List<Integer> array) {

        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(array.size());
        Collections.sort(array);
        int quantidadePares = 0;

        for (Integer numero : array) pilha.push(numero);

        int numeroAnterior = pilha.pop();
        while (!pilha.vazia()) {
            int topo = pilha.pop();
            if (topo < numeroAnterior) quantidadePares++;

            numeroAnterior = topo;
        }

        return quantidadePares;
    }
}
