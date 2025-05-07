//Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real. Em seguida, modifique o vetor de modo que os valores das posições ímpares sejam aumentados em 5% e os das posições pares sejam aumentados em 2%. Imprima o vetor resultante. Faça um método para ler os valores, outro para ajustar os valores dentro do vetor e outro para escrever os valores atualizados do vetor.

import java.util.Scanner;

public class Uni6Exe03 {
    public static void main(String[] args) {
        double vetorN[] = Ler();
        ModificaVetor(vetorN);
        Imprimir(vetorN);
    }

    private static double[] Ler() {
        Scanner scan = new Scanner(System.in);
        double vetorN[] = new double[3];
        System.out.print("Digite os 12 valores: ");
        for (int i = 0; i < vetorN.length; i++) {
            vetorN[i] = scan.nextDouble();
        }
        scan.close();
        return vetorN;
    }

    private static double[] ModificaVetor(double[] vetorN) {
        for (int i = 0; i < vetorN.length; i++) {
            if (i % 2 != 0) {
                vetorN[i] = vetorN[i] + (vetorN[i] * 0.05);
            } else if (i % 2 == 0) {
                vetorN[i] = vetorN[i] + (vetorN[i] * 0.02);
            }
        }
        return vetorN;
    }

    private static void Imprimir(double[] vetorN) {
        System.out.print("Valores após o ajuste: ");
        for (int i = 0; i < vetorN.length; i++) {
            System.out.println(vetorN[i]);
        }
    }

}
