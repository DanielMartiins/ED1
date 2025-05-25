package Exercicio4;

import Exercicio3.ListaGenerica;

public class Frase extends ListaGenerica<String> {

    public Frase(String str) {
        separarFraseEmTokens(str);
    }

    private void separarFraseEmTokens(String str) {
        /*
         * Complexidade alcan�ada: O(N)
         * Motivo:
         *      Executo um loop que vai do 1� at� o N-esimo caracter da string e acredito que, no pior caso,
         *  o m�todo reverse() tamb�m ter� complexidade O(N) mas ser� executado uma �nica vez, e n�o N vezes.
         *  Isso porque acredito que o reverse() ter� complexidade O(N) quando eu tiver algo como "AAAAAAAAA...",
         *  ou seja, minha lista tendo um �nico token de tamanho N e portanto, reverse() sendo chamado uma �nica
         *  vez ap�s uma �nica itera��o do loop do-while indo diretamente de 0 a N. Assim, a complexidade do
         *  meu m�todo fica em O(N).
         */
        String pontuacoes = ".,:;!?-\"()";
        int indexStr = str.length();

        //Esse loop � O(N). Vou do 1� caracter ao N-�simo.
        //Tive que ir do final da string pro come�o, se n�o as palavras v�o ficar em ordem contr�ria na lista
        while (indexStr > 0) {
            StringBuilder token = new StringBuilder();
            int tamToken = 0;
            do {
                indexStr--;
                char caracterDaString = str.charAt(indexStr);


                if (caracterDaString == ' ')
                    break;
                else {
                    if (pontuacoes.contains(String.valueOf(caracterDaString))) {
                        this.insere(String.valueOf(caracterDaString));
                        break;
                    } else if (Character.isAlphabetic(caracterDaString)) {
                        token.append(caracterDaString); //append() do StringBuilder � O(1).
                        tamToken++;
                    }
                }
            } while (indexStr > 0);
            if (tamToken != 0) this.insere(token.reverse().toString()); //reverse() e toString() do StringBuilder � O(N)
        }
    }
}
