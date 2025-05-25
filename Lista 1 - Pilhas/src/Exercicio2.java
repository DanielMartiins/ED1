import java.util.Scanner;

public class Exercicio2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Insira a string no formato sDsDs...Ds, sendo cada 's' uma sequencia de letras A e B no formato \"xCy\"");
        if (formatoValido(scanner.nextLine()))
            System.out.println("Está no formato válido");
        else
            System.out.println("Não está em um formato válido");

    }

    private static boolean formatoValido(String string) {

        Pilha pilhaString = new Pilha(string.length());

        for (int i = 0; i < string.length(); i++) pilhaString.push(string.charAt(i));

        //Considero subsequencia a sequencia que está separada entre os caracteres 'D'
        int qtdCaracterCsubsequencia = 0;
        int qtdSubsequencias = 1;
        while (!pilhaString.vazia()) {
            char caracter = pilhaString.pop();

            if (caracter == 'C') qtdCaracterCsubsequencia++;
            else if (caracter == 'D') {
                if (qtdCaracterCsubsequencia == 0 || qtdCaracterCsubsequencia >= 2) return false;
                else {
                    qtdCaracterCsubsequencia = 0;
                    qtdSubsequencias++;
                }
            } else if (caracter != 'A' && caracter != 'B' && caracter != ' ') return false;
        }
        return qtdSubsequencias > 1;
    }
}
