package FarmaStock;

import java.util.Scanner; // Importamos o Scanner para ler o teclado

public class main {

    public static void main(String[] args) {

        // Scanner é ligado ao System.in, que representa o teclado
        Scanner scanner = new Scanner(System.in);

        Estoque estoque = new Estoque();

        // Variável que controla se o programa continua rodando
        boolean rodando = true;

        // while: fica repetindo enquanto "rodando" for true
        while (rodando) {

            // Mostra o menu de opções
            System.out.println("\n===== FARMASTOCK =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Registrar entrada");
            System.out.println("3 - Registrar saída");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê o número que o usuário digitou
            int opcao = Integer.parseInt(scanner.nextLine());

            // switch: direciona para o bloco certo conforme a opção
            switch (opcao) {

                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(scanner.nextLine());

                    estoque.cadastrarProduto(nome, quantidade, preco);
                    break; // Sai do switch

                case 2:
                    System.out.print("Nome do produto: ");
                    String nomEntrada = scanner.nextLine();

                    System.out.print("Quantidade de entrada: ");
                    int qtdEntrada = Integer.parseInt(scanner.nextLine());

                    estoque.registrarEntrada(nomEntrada, qtdEntrada);
                    break;

                case 3:
                    System.out.print("Nome do produto: ");
                    String nomeSaida = scanner.nextLine();

                    System.out.print("Quantidade de saída: ");
                    int qtdSaida = Integer.parseInt(scanner.nextLine());

                    estoque.registrarSaida(nomeSaida, qtdSaida);
                    break;

                case 4:
                    estoque.listarProdutos();
                    break;

                case 0:
                    System.out.println("👋 Encerrando o sistema. Até logo!");
                    rodando = false; // Para o while
                    break;

                default:
                    // Executado quando nenhum case corresponde à opção
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        scanner.close(); // Boa prática: sempre fechar o Scanner ao terminar
    }
}