import java.util.Scanner;

public class Exercicio6 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira a string:");
        imprimirStringInversa(scanner.nextLine());
    }

    private static void imprimirStringInversa(String string) {
        Pilha pilhaString = new Pilha(string.length());

        for (int i = 0; i < string.length(); i++) pilhaString.push(string.charAt(i));
        while (!pilhaString.vazia()) System.out.print(pilhaString.pop());
    }
}
