import java.util.Scanner;

public class testeExcluir {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vetor[] = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("Informe o número a ser excluído: ");
        int nExclui = scan.nextInt();
        for (int i = 0; i < vetor.length; i++) {
            if (nExclui == vetor[i]) {
                System.out.println("O número " + nExclui + " encontrado na posição " + i + " foi excluído.");
                for (int j = i; j < (vetor.length - 1); j++) {
                    vetor[j] = vetor[j + 1];
                    System.out.println(vetor[j]);
                }
                return;
            }
        }
        System.out.println("O número " + nExclui + " não foi encontrado no vetor.");
    }
}
