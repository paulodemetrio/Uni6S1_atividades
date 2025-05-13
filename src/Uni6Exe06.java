// Faça um programa que leia um valor N inteiro. Com base neste valor, crie um vetor do tipo real. Em seguida, solicite ao usuário informar essa quantidade N de valores reais para popular o vetor. Após ter preenchido o vetor, solicite que o usuário informe um outro valor real. Informe para o usuário se este valor informado se encontra cadastrado no vetor. Faça um método para ler o vetor e outro, que retorne verdadeiro ou falso, para encontrar o valor.

import java.util.Scanner;

public class Uni6Exe06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nVetor;
        do {
            System.out.println("Digite um número inteiro positivo: ");
            nVetor = scan.nextInt();
        } while (nVetor <= 0);
        double[] vetor = LerValor(scan, nVetor);
        EncontraValor(scan, vetor);
    }

    private static double[] LerValor(Scanner scan, int nVetor){
        double[] vetor = new double[nVetor];
        System.out.println("Informe " + nVetor + " números reais para guardar no vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = scan.nextDouble();
        }
        return vetor;
    }

    private static void EncontraValor(Scanner scan, double[] vetor){
        System.out.println("Informe por fim outro valor real, podendo estar no vetor ou não.");
        double valor = scan.nextDouble();
        
    }
}
