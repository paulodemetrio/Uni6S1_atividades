import java.util.Scanner;

public class Mochila {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tam;
        int peso;

        System.out.print("Quantos itens sua mochila pode ter? ");
        tam = scan.nextInt();
        System.out.print("Qual o peso máximo que poderá levar (em kg)? ");
        peso = scan.nextInt();
        scan.nextLine();

        Mochila mochila = new Mochila(tam, peso);

        int op;
        do {
            System.out.println("MENU");
            System.out.println("1 - Inserir na mochila");
            System.out.println("2 - Ver mochila");
            System.out.println("3 - Ver o item mais pesado");
            System.out.println("4 - Organizar a mochila");
            System.out.println("5 - Excluir da mochila");
            System.out.println("0 - Sair");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeItem = scan.nextLine();
                    System.out.print("Peso do item (kg): ");
                    int pesoItem = scan.nextInt();
                    scan.nextLine();
                    mochila.inserir(nomeItem, pesoItem);
                    break;
                case 2:
                    mochila.imprimirMochila();
                    break;
                case 3:
                    System.out.println(mochila.valorItemMaisPesado());
                    break;
                case 4:
                    mochila.ordenarMochila();
                    mochila.imprimirMochila();
                    break;
                case 5:
                    System.out.print("Qual item quer excluir? ");
                    String itemExcluido = scan.nextLine();
                    mochila.excluirItemMochila(itemExcluido);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tenta de novo.");
            }
        } while (op != 0);
        scan.close();
    }

    String[] nome;
    int[] peso;
    int maximoPesos;
    int maximoItens;
    int pesoTot;
    int qtdeItens;

    public Mochila(int itensMax, int pesoMax) {
        maximoItens = itensMax;
        maximoPesos = pesoMax;

        nome = new String[maximoItens];
        peso = new int[maximoItens];

        pesoTot = 0;
        qtdeItens = 0;
    }

    public void inserir(String nomeItem, int pesoItem) {
        if (qtdeItens >= maximoItens) {
            System.out.println("Sem espaço na mochila.");
            return;
        }
        if (pesoTot + pesoItem > maximoPesos) {
            System.out.println("Item não adiocionado, pois ultrapassa o peso máximo da mochila.");
            return;
        }

        nome[qtdeItens] = nomeItem;
        peso[qtdeItens] = pesoItem;

        pesoTot += pesoItem;
        qtdeItens++;

        System.out.println("Item adicionado na mochila. Peso atual: " + pesoTot + " kg.");
    }

    public void imprimirMochila() {
        if (qtdeItens == 0) {
            System.out.println("A mochila está vazia.");
            return;
        }
        for (int i = qtdeItens - 1; i >= 0; i--) {
            if (nome[i] != null) {
                System.out.println(" - " + nome[i] + " (" + peso[i] + " kg)");
            }
        }
        System.out.println("Peso total: " + pesoTot + " kg. Capacidade máxima: " + maximoPesos + " kg.");
        System.out.println("Espaço sobrando: " + (maximoItens - qtdeItens));
    }

    public String valorItemMaisPesado() {
        if (qtdeItens == 0) {
            return "Nada na mochila pra ser pesado.";
        }

        String itemMaisPesado = "";
        int maiorPeso = 0;

        for (int i = 0; i < qtdeItens; i++) {
            if (peso[i] > maiorPeso) {
                maiorPeso = peso[i];
                itemMaisPesado = nome[i];
            }
        }
        return "O maior peso é: '" + itemMaisPesado + "' com " + maiorPeso + " kg.";
    }

    public void ordenarMochila() {
        if (qtdeItens <= 1) {
            System.out.println("Mochila já organizada.");
            return;
        }

        System.out.println("Organizando a mochila.");
        for (int i = 0; i < qtdeItens - 1; i++) {
            for (int j = 0; j < qtdeItens - 1 - i; j++) {
                if (peso[j] > peso[j + 1]) {
                    int tempPeso = peso[j];
                    peso[j] = peso[j + 1];
                    peso[j + 1] = tempPeso;

                    String tempNome = nome[j];
                    nome[j] = nome[j + 1];
                    nome[j + 1] = tempNome;
                }
            }
        }
        System.out.println("A mochila foi organizada.");
    }

    public void excluirItemMochila(String itemExcluido) {
        int posItem = -1;
        for (int i = 0; i < qtdeItens; i++) {
            if (nome[i] != null && nome[i].equalsIgnoreCase(itemExcluido)) {
                posItem = i;
                break;
            }
        }

        if (posItem == -1) {
            System.out.println("O item '" + itemExcluido + "' não está na mochila.");
            return;
        }

        int pesoRemvido = peso[posItem];
        pesoTot -= pesoRemvido;

        for (int i = posItem; i < qtdeItens - 1; i++) {
            nome[i] = nome[i + 1];
            peso[i] = peso[i + 1];
        }

        nome[qtdeItens - 1] = null;
        peso[qtdeItens - 1] = 0;
        qtdeItens--;

        System.out.println("Excluído o item '" + itemExcluido + "'. Peso atual: " + pesoTot + " kg.");
    }
}