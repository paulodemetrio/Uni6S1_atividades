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
        String enunciado = "Responda com SIM, NAO ou IND (indiferente)";
        String perguntas[] = { "Gosta de música sertaneja? ", "Gosta de futebol? ", "Gosta de seriados? ", "Gosta de redes sociais? ", "Gosta da Oktoberfest? " };
        System.out.println("Respostas do rapaz: ");
        String[] resRapaz = Ler(scan, enunciado, perguntas);
        System.out.println("--------------------------");
        System.out.println("Respostas da moça: ");
        String[] resMoca = Ler(scan, enunciado, perguntas);
        System.out.println("--------------------------");
        CalculaAfinidade(resRapaz, resMoca);
    }

    private static String[] Ler(Scanner scan, String enunciado, String[] perguntas) {
        String[] respostas = new String[5];
        for (int i = 0; i < respostas.length; i++) {
            System.out.println(enunciado);
            do {
                System.out.print(perguntas[i]);
                respostas[i] = scan.next().toUpperCase();
                if (!(respostas[i].equals("SIM") || respostas[i].equals("NAO") || respostas[i].equals("IND"))) {
                    System.out.println("Resposta inválida. Digite SIM, NAO ou IND.");
                }
            } while (!(respostas[i].equals("SIM") || respostas[i].equals("NAO") || respostas[i].equals("IND")));
        }
        return respostas;
    }

    private static void CalculaAfinidade(String[] resRapaz, String[] resMoca) {
        int pontoAfinidade = 0;
        int totalAfinidade = 0;
        for (int i = 0; i < resRapaz.length; i++) {
            if (resRapaz[i].equals(resMoca[i])) {
                pontoAfinidade = 3;
            } else if (resRapaz[i].equals("IND") || resMoca[i].equals("IND")) {
                pontoAfinidade = 1;
            } else {
                pontoAfinidade = -2;
            }
            totalAfinidade += pontoAfinidade;
            pontoAfinidade = 0;
        }
        if (totalAfinidade <= -10) {
            System.out.println("Afinidade: " + totalAfinidade + ". Vocês se odeiam!");
        } else if (totalAfinidade >= -9 && totalAfinidade <= -1) {
            System.out.println("Afinidade: " + totalAfinidade + ". Melhor não peder tempo.");
        } else if (totalAfinidade >= 0 && totalAfinidade <= 4) {
            System.out.println("Afinidade: " + totalAfinidade + ". Vale um encontro.");
        } else if (totalAfinidade >= 5 && totalAfinidade <= 9) {
            System.out.println("Afinidade: " + totalAfinidade + ". Talvez não dê certo :(");
        } else if (totalAfinidade >= 10 && totalAfinidade <= 14) {
            System.out.println("Afinidade: " + totalAfinidade + ". Vocês têm muita coisa em comum!");
        } else if (totalAfinidade >= 15) {
            System.out.println("Afinidade: " + totalAfinidade + ". Casem!");
        }
    }

}
