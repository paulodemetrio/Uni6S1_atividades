//Faça um programa para ler os valores de dois vetores de inteiros, cada um contendo 10 elementos. Crie um terceiro vetor em que cada elemento é a soma dos valores contidos nas posições respectivas dos vetores originais. Por exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. Exiba, ao final, os três vetores na tela. Faça três métodos: um método para ler valores dos vetores, outro para somar e outro para escrever os vetores.

import java.util.Scanner;

public class Uni6Exe04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetor1 = Ler(scan);
        int[] vetor2 = Ler(scan);
        int vetor3[] = new int[10];
        vetor3 = Soma(vetor1, vetor2, vetor3);
        Escrever(vetor1, vetor2, vetor3);
        scan.close();
    }
    
    private static int[] Ler(Scanner scan) {
        int vetor[] = new int[10];
        System.out.print("Digite os valores: ");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = scan.nextInt();
        }
        return vetor;
    }
    
    private static int[] Soma(int[] vetor1, int[] vetor2, int[] vetor3) {
        for (int i = 0; i < vetor3.length; i++) {
            vetor3[i] = vetor1[i] + vetor2[i];
        }
        return vetor3;
    }
    
    private static void Escrever(int[] vetor1, int[] vetor2, int[] vetor3) {
        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                System.out.println("Valores do vetor " + i + " : ");
                for (int j = 0; j < vetor1.length; j++) {
                    System.out.print(vetor1[j] + " | ");
                }
            } else if (i == 2) {
                System.out.println("Valores do vetor " + i + " : ");
                for (int j = 0; j < vetor2.length; j++) {
                    System.out.print(vetor2[j] + " | ");
                }
            } else if (i == 3) {
                System.out.println("Valores do vetor " + i + " (vetor " + (i - 2) + " + vetor " + (i - 1) + ") : ");
                for (int j = 0; j < vetor3.length; j++) {
                    System.out.print(vetor3[j] + " | ");
                }
            }
            System.out.println();
        }
    }
}
