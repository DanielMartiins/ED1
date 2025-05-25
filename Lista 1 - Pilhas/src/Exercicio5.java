import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercicio5 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira a string:");
        if (balanceado(scanner.nextLine()))
            System.out.println("Está balanceado");
        else
            System.out.println("Não está balanceado");
    }

    private static boolean balanceado(String string) {
        Pilha pilhaString = new Pilha(string.length());
        Pilha delimitadorEsperado = new Pilha(string.length());
        List<Character> delimitadoresFechados = Arrays.asList('}', ')', ']');
        List<Character> delimitadoresAbertos = Arrays.asList('{', '(', '[');
        Map<Character, Character> parDoDelimitadorFechado = Map.ofEntries(
                Map.entry('}', '{'),
                Map.entry(')', '('),
                Map.entry(']', '[')
        );

        for (int i = 0; i < string.length(); i++) pilhaString.push(string.charAt(i));

        while (!pilhaString.vazia()) {
            char caracter = pilhaString.pop();

            if (delimitadoresFechados.contains(caracter))
                delimitadorEsperado.push(parDoDelimitadorFechado.get(caracter));
            else if (delimitadoresAbertos.contains(caracter))
                if (caracter != delimitadorEsperado.pop()) return false;
        }
        return true;
    }
}