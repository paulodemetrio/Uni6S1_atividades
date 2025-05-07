/* Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça cada um respondeu um questionário com 5 perguntas, como por exemplo:

Gosta de música sertaneja?
Gosta de futebol?
Gosta de seriados?
Gosta de redes sociais?
Gosta da Oktoberfest?
A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice de afinidade é medido da seguinte maneira:

se ambos deram a mesma resposta soma-se 3 pontos ao índice;
se um respondeu IND e o outro SIM ou NÃO soma-se 1;
se um respondeu SIM e o outro NÃO subtrai-se 2 ao índice.
Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as respostas da moça. Crie um método que possa ler tanto as respostas do rapaz como da moça, e outro para calcular e retornar a afinidade. Por fim, escreva a afinidade considerando os seguintes intervalos:

Afinidade	Mensagem
15          “Casem!
10 a 14	    “Vocês têm muita coisa em comum!”
5 a 9	    “Talvez não dê certo :(”
0 a 4	    “Vale um encontro.”
-1 a -9	    “Melhor não perder tempo”
-10	        “Vocês se odeiam!” */

import java.util.Scanner;

public class Uni6Exe05 {    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] respostasRapaz = Ler(scan);
        String[] respostasMoca = Ler(scan);
    }

    private static String[] Ler(Scanner scan){
        String[] respostas = new String[5];
        String perguntas[] = {"Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?", "Gosta de redes sociais?", "Gosta da Oktoberfest?"};
        for (int i = 0; i < respostas.length; i++) {
            System.out.print(perguntas[i]);
            respostas[i] = scan.next();
        }
    }

    
}
