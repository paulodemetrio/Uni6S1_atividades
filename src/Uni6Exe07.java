/* Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor do tipo inteiro. Em seguida, solicite ao usuário para digitar um número inteiro várias vezes, até preencher o vetor. Esse número deverá ser armazenado no vetor caso ainda não exista, e se o valor já existir deve ser pedido um novo valor. Isto é, se o usuário informar o número 2 e já existir o número 2 em alguma posição do vetor, o número não deve ser adicionado. Após ter adicionado todos os números dentro do vetor, o mesmo deve ser ordenado. Para isso reordene os elementos internos do vetor de modo que este fique em ordem crescente, conforme no exemplo:

Vetor origem: [0][4][2][6][3]
Vetor ordenado: [0][2][3][4][6]

Crie um método para inserir os valores no vetor, outro para ordenar o vetor e outro para informar o vetor resultante. Para "método ordenar" se pode usar o "método bolha" explicado neste vídeo.
*/

import java.util.Scanner;

public class Uni6Exe07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int valor = 0;
        do {
            System.out.println("Digite um valor inteiro até 20: ");
            valor = scan.nextInt();
            if (valor > 20 || valor < 1) {
                System.out.println("Valor inválido.");
            }
        } while (valor > 20 || valor < 1);
        int vetor[] = new int[valor];
        InformaVetor(scan, valor, vetor);
    }

    private static int[] InformaVetor(Scanner scan, int valor, int[] vetor){
        int encontrado = 0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um número inteiro: ");
            vetor[i] = scan.nextInt();
            do {
                for (int j = 0; j < vetor.length; j++) {
                    if (vetor[i] == vetor[j]) {
                        encontrado = vetor[j];
                        System.out.println("Valor já digitado no vetor.");
                        System.out.println("Digite outro valor: ");
                        vetor[i] = scan.nextInt();
                    }
                }
                encontrado = 0;
            } while (encontrado != 0);
        }
        System.out.println("Mostrando o vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": [" + vetor[i] + "]");
        }
        return vetor;
    }
}
