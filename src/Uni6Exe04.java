//Faça um programa para ler os valores de dois vetores de inteiros, cada um contendo 10 elementos. Crie um terceiro vetor em que cada elemento é a soma dos valores contidos nas posições respectivas dos vetores originais. Por exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. Exiba, ao final, os três vetores na tela. Faça três métodos: um método para ler valores dos vetores, outro para somar e outro para escrever os vetores.

import java.util.Scanner;

public class Uni6Exe04 {
    public static void main(String[] args) {
        int[] vetor1 = Ler();
        int[] vetor2 = Ler();
        int vetor3[] = null;
        vetor3 = Soma(vetor1, vetor2, vetor3);
        Escrever(vetor3);
    }

    private static int[] Ler(){
        Scanner scan = new Scanner(System.in);
        int vetor[] = new int[10];
        System.out.println("Digite os valores: ");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = scan.nextInt();
        }
        scan.close();
        return vetor;
    }

    private static int[] Soma(int[] vetor1, int[] vetor2, int[] vetor3){
        for (int i = 0; i < vetor1.length; i++) {
            for (int j = 0; j < vetor2.length; j++) {
                vetor3[i] = vetor1[i] + vetor2[i];
            }
        }
        return vetor3;
    }

    private static void Escrever(int[] vetor) {
        System.out.println("Os valores somados resultaram no seguinte vetor:");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.print(vetor[i] + " | ");
        }
    }
}
