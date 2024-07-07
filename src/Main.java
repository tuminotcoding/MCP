import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDePassagens listaDePassagens = new ListaDePassagens();
        listaDePassagens.adicionarVoo(new Voo("São Paulo", "Rio de Janeiro", "2024-07-01", 300.00));
        listaDePassagens.adicionarVoo(new Voo("São Paulo", "Paris", "2024-07-15", 2500.00));

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha após o nextInt()

            switch (opcao) {
                case 1:
                    mostrarPassagens(listaDePassagens.getVoosDisponiveis());
                    break;
                case 2:
                    comprarPassagem(scanner, listaDePassagens, cliente);
                    break;
                case 3:
                    mostrarCarrinho(cliente);
                    break;
                case 4:
                    finalizarCompra(cliente);
                    executando = false; // Finaliza o programa após finalizar a compra
                    break;
                case 5:
                    executando = false;
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Mostrar passagens disponíveis");
        System.out.println("2. Comprar passagem");
        System.out.println("3. Mostrar carrinho");
        System.out.println("4. Finalizar compra");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void mostrarPassagens(List<Voo> voos) {
        System.out.println("=== Passagens Disponíveis ===");
        for (int i = 0; i < voos.size(); i++) {
            System.out.println((i + 1) + ". " + voos.get(i));
        }
        System.out.println("=============================");
    }

    private static void comprarPassagem(Scanner scanner, ListaDePassagens listaDePassagens, Cliente cliente) {
        System.out.println("Escolha um voo pelo número:");
        List<Voo> voos = listaDePassagens.getVoosDisponiveis();
        mostrarPassagens(voos);

        int numeroVooEscolhido = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha após o nextInt()

        if (numeroVooEscolhido >= 1 && numeroVooEscolhido <= voos.size()) {
            Voo vooEscolhido = voos.get(numeroVooEscolhido - 1);

            System.out.print("Digite a quantidade de passagens: ");
            int quantidadePassagens = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha após o nextInt()

            for (int i = 0; i < quantidadePassagens; i++) {
                Passagem passagem = new Passagem(vooEscolhido, cliente.getNome(), vooEscolhido.getPreco());
                cliente.adicionarPassagem(passagem);
                System.out.println("Passagem adicionada ao carrinho: " + passagem);
            }
        } else {
            System.out.println("Número de voo inválido.");
        }
    }

    private static void mostrarCarrinho(Cliente cliente) {
        List<Passagem> carrinho = cliente.getCarrinho();
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("=== Carrinho de Passagens ===");
            for (Passagem passagem : carrinho) {
                System.out.println(passagem);
            }
            System.out.println("=============================");
        }
    }

    private static void finalizarCompra(Cliente cliente) {
        List<Passagem> carrinho = cliente.getCarrinho();
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Nenhuma passagem comprada.");
        } else {
            double total = cliente.calcularTotalCarrinho();
            System.out.println("=== Passagens Compradas ===");
            for (Passagem passagem : carrinho) {
                System.out.println(passagem);
            }
            System.out.println("Total: R$ " + total);
            cliente.finalizarCompra();
            System.out.println("Compra finalizada. Obrigado!");
        }
    }
}


