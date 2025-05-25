import java.util.Scanner;


public class Exercicio1 {


    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Insira a string no formato (xCy): ");
        String str = scanner.nextLine();
        scanner.close();

        if (!stringNoFormatoValido(str)) {
            System.err.println("String no formato inválido!");
            System.exit(0);
        } else {

            if (stringsSaoInversas(str))
                System.out.println("As strings são inversas uma da outra");
            else
                System.out.println("As strings não são inversas uma da outra");
        }
    }

    private static boolean stringNoFormatoValido(String str) {

        int qtdCaracterC = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C')
                qtdCaracterC++;
            else if (str.charAt(i) != 'A' && str.charAt(i) != 'B' && str.charAt(i) != ' ')
                return false;
        }
        return qtdCaracterC == 1;
    }

    private static boolean stringsSaoInversas(String str) {

        StringBuilder stringX = new StringBuilder();
        StringBuilder stringY = new StringBuilder();
        Pilha pilhaStringY = new Pilha(stringY.length());

        //Separar a string do usuário em stringX e stringY
        for (int i = 0; str.charAt(i) != 'C'; i++) stringX.append(str.charAt(i));
        for (int i = stringX.length() + 1; i < str.length(); i++) stringY.append(str.charAt(i));

        //Passar a stringY para a pilha auxiliar 'pilhaStringY'
        for (int i = 0; i < stringY.length(); i++) pilhaStringY.push(stringY.charAt(i));

        //Verificar de fato se X e Y são inversas
        for (int i = 0; i < stringX.length(); i++) {
            char caracterStrA = stringX.charAt(i);
            char caracterStrB = pilhaStringY.pop();
            if (caracterStrA != caracterStrB)
                return false;
        }
        return true;
    }
}
