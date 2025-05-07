//Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real. Imprima quais valores desses informados são maiores que a média dos valores. Faça um método para ler os valores, outro para calcular a média e outro para informar os valores maiores que a média.

import java.text.DecimalFormat;
import java.util.Scanner;

public class Uni6Exe02 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        double vetorN[] = Ler();
        double media = Media(vetorN);
        System.out.println("Media: " + df.format(media));
        EscreverAcimaDaMedia(vetorN, media);
    }

    private static double[] Ler() {
        Scanner scan = new Scanner(System.in);
        double vetorN[] = new double[12];
        System.out.print("Digite os 12 valores: ");
        for (int i = 0; i < vetorN.length; i++) {
            vetorN[i] = scan.nextDouble();
        }
        scan.close();
        return vetorN;
    }

    private static double Media(double[] vetorN) {
        double media = 0;
        double soma = 0;
        for (int i = 0; i < vetorN.length; i++) {
            soma += vetorN[i];
        }
        media = soma / vetorN.length;
        return media;
    }

    private static void EscreverAcimaDaMedia(double[] vetorN, double media) {
        System.out.print("Os valores acima da média são: ");
        for (int i = 0; i < vetorN.length; i++) {
            if (vetorN[i] > media) {
                System.out.print(vetorN[i] + " / ");
            }
        }
    }
}
