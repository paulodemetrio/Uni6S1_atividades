//Descreva um algoritmo que leia 10 números inteiros e os coloque em um vetor de 10 posições do tipo inteiro. Escreva na ordem inversa em que foram lidos. Faça um método para ler e outro para escrever.

import java.util.Scanner;

public class Uni6Exe01 {
    public static void main(String[] args) {
        int vetorN[] = Ler();
        Escrever(vetorN);
    }
    
    private static int[] Ler() {
        Scanner scan = new Scanner(System.in);
        int vetorN[] = new int[10];
        System.out.println("Digite os 10 valores inteiros: ");
        for (int i = 0; i < vetorN.length; i++) {
            vetorN[i] = scan.nextInt();
        }
        scan.close();
        return vetorN;
    }

    private static void Escrever(int[] vetorN) {
        System.out.println("Os valores lidos foram:");
        for (int i = vetorN.length - 1; i >= 0; i--) {
            System.out.println(vetorN[i]);
        }
    }
}
