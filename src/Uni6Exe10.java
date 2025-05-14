/* Dado um vetor de números inteiros, com capacidade limitada a 50 elementos, faça um programa que construa um menu com as seguintes opções:

“1 – Incluir valor ”: nesta opção inclua o valor no fim do vetor, se houver espaço. Informe o usuário se o valor foi incluído no vetor ou não;
“2 – Pesquisar valor ”: nesta opção leia um valor e informe se o mesmo está no vetor;
“3 – Alterar valor ”: nesta opção informe um número a ser alterado e um novo número a ser colocado no lugar (só para a primeira ocorrência deste número). Caso o número a ser alterado exista no vetor, substitua-o pelo novo número. Caso contrário, informe “número não encontrado”;
“4 – Excluir valor ”: nesta opção leia um valor e, caso ele esteja no vetor, exclua-o. Informe o usuário se o valor foi excluído do vetor ou não. A posição que foi excluída o valor deve ser preenchida pelo valor seguinte, sucessivamente até o final dos valores do vetor;
“5 – Mostrar valores ”: nesta opção mostre todos os valores armazenados no vetor;
“6 – Ordenar valores ”: ordene todos os valores do vetor em ordem crescente;
“7 – Inverter valores ”: desafio (ver abaixo);
“8 – Sair do sistema ”: nesta opção deve ser finalizada a execução do programa.
Faça um método para cada uma das opções do menu. O menu deve-se repetir até que o usuário escolha a opção 8.
Para a opção "6 - Ordenar valores" se pode usar o "método bolha" explicado neste vídeo. Existem também outros vídeos que mostram a lógica de ordenação usando o "método bolha", no caso é só procurar por "Bubble Sort". Um deles é Bubble Sort | GeeksforGeeks. Um outro um pouco mais "divertido" procura mostrar a lógica usando uma coreografia de dança: Bubble sort with Hungarian, folk dance. E, por fim, tem uma forma interativa e visual com explicação em: https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/.
Desafio: adapte o código acima para ter mais uma opção no menu para também poder inverter os elementos dentro de um vetor. Assim o último elemento passa a ser o primeiro, o penúltimo passa ser o segundo, e assim sucessivamente para todos os elementos da lista. Mas lembre, não se deve considerar o vetor inteiro, mas somente os elementos que já foram adicionados no vetor. Como base use o código descrito em vetorInverter.java.*/

import java.util.Arrays;
import java.util.Scanner;

public class Uni6Exe10 {
    public static void main(String[] args) {
        Programa();
    }

    private static String Programa() {
        Scanner scan = new Scanner(System.in);
        int op = 0, posicao = 0;
        int vetor[] = new int[50];
        do {
            System.out.println("--------------------");
            System.out.println("1 - Incluir valor");
            System.out.println("2 - Pesquisar valor");
            System.out.println("3 - Alterar valor");
            System.out.println("4 - Excluir valor");
            System.out.println("5 - Mostrar valores");
            System.out.println("6 - Ordenar valores");
            System.out.println("7 - Inverter valores");
            System.out.println("8 - Sair do sistema");
            System.out.println("--------------------");
            op = scan.nextInt();
            System.out.println("Opção digitada: " + op);

            switch (op) {
                case 1:
                    posicao = IncluirValor(scan, vetor, posicao);
                    break;
                case 2:
                    PesquisaValor(scan, vetor);
                    break;
                case 3:
                    AlteraValor(scan, vetor);
                    break;
                case 4:
                    ExcluirValor(scan, vetor);
                    break;
                case 5:
                    MostrarVetor(vetor, posicao);
                    break;
                case 6:
                    OrdenarVetor(vetor, posicao);
                    break;
                case 7:
                    InverterVetor(vetor, posicao);
                    break;
                case 8:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 8);
        return "Teste";
    }

    private static int IncluirValor(Scanner scan, int[] vetor, int posicao) {
        System.out.println("Digite um número a ser incluído no vetor: ");
        int n = scan.nextInt();
        if (posicao < vetor.length) {
            vetor[posicao] = n;
            System.out.println("A posição " + posicao + " recebeu o número " + n);
        } else {
            System.out.println("Não há mais espaço no vetor!");
        }
        return posicao + 1;
    }

    private static void PesquisaValor(Scanner scan, int[] vetor) {
        System.out.println("Informe o valor a ser pesquisado no vetor.");
        int valor = scan.nextInt();
        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (valor == vetor[i]) {
                contador++;
                System.out.println("Valor encontrado na posição " + i + ".");
            }
        }
        if (contador > 0) {
            System.out.println("O número " + valor + " aparece no vetor " + contador + "x.");
        } else {
            System.out.println("O número " + valor + " não está no vetor.");
        }
    }

    private static void AlteraValor(Scanner scan, int[] vetor) {
        System.out.println("Informe o número a ser alterado: ");
        int nSai = scan.nextInt();
        for (int i = 0; i < vetor.length; i++) {
            if (nSai == vetor[i]) {
                System.out.println("O número " + nSai + " foi encontrado na posição " + i + ".");
                System.out.println("Informe o novo número a ocupar essa posição: ");
                int nEntra = scan.nextInt();
                vetor[i] = nEntra;
                System.out.println("O número " + nEntra + " irá ocupar a posição " + i + ".");
                return;
            }
        }
        System.out.println("O número" + nSai + " não foi encontrado.");
    }

    private static void ExcluirValor(Scanner scan, int[] vetor) {
        System.out.println("Informe o número a ser excluído: ");
        int nExclui = scan.nextInt();
        for (int i = 0; i < vetor.length; i++) {
            if (nExclui == vetor[i]) {
                System.out.println("O número " + nExclui + " encontrado na posição " + i + " foi excluído.");
                for (int j = i; j < (vetor.length - 1); j++) {
                    vetor[j] = vetor[j + 1];
                }
                return;
            }
        }
        System.out.println("O número " + nExclui + " não foi encontrado no vetor.");
    }

    private static void MostrarVetor(int[] vetor, int posicao) {
        System.out.println("Mostrando o vetor: ");
        for (int i = 0; i < posicao; i++) {
            System.out.println("Posição " + i + ": [" + vetor[i] + "]");
        }
    }

    private static void OrdenarVetor(int[] vetor, int posicao) {
        /*
         * Método padrão:
         * Arrays.sort(vetor);
         * for (int i = 0; i < posicao; i++) {
         * System.out.println("Posição " + i + ": [" + vetor[i] + "]");
         * }
         */
        int temporaria = 0;
        for (int i = 0; i < posicao - 1; i++) {
            for (int j = 0; j < posicao - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    temporaria = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temporaria;
                }
            }
        }
        System.out.println("Vetor ordenado com sucesso!");
    }

    private static void InverterVetor(int vet[], int posicao) {
        int temp = 0;
        for (int i = 0; i < posicao; i++) {
            for (int j = 0; j < i; j++) {
                temp = vet[i];
                vet[i] = vet[j];
                vet[j] = temp;
            }
        }
        System.out.println("Vetor invertido com sucesso!");
    }
}
