package Exercicio4;

import Exercicio3.ListaGenerica;

public class Frase extends ListaGenerica<String> {

    public Frase(String str) {
        separarFraseEmTokens(str);
    }

    private void separarFraseEmTokens(String str) {
        /*
         * Complexidade alcançada: O(N)
         * Motivo:
         *      Executo um loop que vai do 1º até o N-esimo caracter da string e acredito que, no pior caso,
         *  o método reverse() também terá complexidade O(N) mas será executado uma única vez, e não N vezes.
         *  Isso porque acredito que o reverse() terá complexidade O(N) quando eu tiver algo como "AAAAAAAAA...",
         *  ou seja, minha lista tendo um único token de tamanho N e portanto, reverse() sendo chamado uma única
         *  vez após uma única iteração do loop do-while indo diretamente de 0 a N. Assim, a complexidade do
         *  meu método fica em O(N).
         */
        String pontuacoes = ".,:;!?-\"()";
        int indexStr = str.length();

        //Esse loop é O(N). Vou do 1º caracter ao N-ésimo.
        //Tive que ir do final da string pro começo, se não as palavras vão ficar em ordem contrária na lista
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
                        token.append(caracterDaString); //append() do StringBuilder é O(1).
                        tamToken++;
                    }
                }
            } while (indexStr > 0);
            if (tamToken != 0) this.insere(token.reverse().toString()); //reverse() e toString() do StringBuilder é O(N)
        }
    }
}
