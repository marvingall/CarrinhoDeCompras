import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicativo {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        List<Integer> carrinho = new ArrayList<>();
        produtos.add(new Produto("Shampoo", 7.0));
        produtos.add(new Produto("Limpol", 5.0));
        produtos.add(new Produto("Pao", 2.0));
        produtos.add(new Produto("Casaco", 12.0));
        produtos.add(new Produto("Abacaxi", 6.0));
        carrinho.add(0); // quantidade de shampoo no carrinho
        carrinho.add(0); // quantidade de limpol no carrinho
        carrinho.add(0); // quantidade de pao no carrinho
        carrinho.add(0); // quantidade de Casaco no carrinho
        carrinho.add(0); // quantidade de Abacaxi no carrinho

        System.out.println("produtos disponiveis: ");

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o número do produto (ou 0 para concluir o pedido): ");
            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            }
            if (opcao < 1 || opcao > produtos.size()) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }
            System.out.println(produtos.get(opcao - 1));
            System.out.println("Qual a quantidade desejada? ");
            int quantidade = scanner.nextInt();

            carrinho.set(opcao - 1, quantidade + carrinho.get(opcao - 1));
        }

        double valorTotal = 0;

        for (int i = 0; i < produtos.size(); i++) {
            valorTotal = valorTotal + produtos.get(i).getValor() * carrinho.get(i);
        }

        System.out.println(valorTotal);

        System.out.println("Escolha a forma de pagamento: ");
        System.out.println("1. Crédito");
        System.out.println("2. Boleto");
        System.out.println("3. PIX");
        int formaPagamento = scanner.nextInt();
        switch (formaPagamento) {
            case 1: // Crédito
                System.out.println("parcelamento em até 6x: ");
                System.out.println("1x: sem juros ");
                System.out.println("2x: sem juros ");
                System.out.println("3x: sem juros ");
                System.out.println("4x: com juros de 4% ao mês");
                System.out.println("5x: com juros de 5% ao mês");
                System.out.println("6x: com juros de 6% ao mês");
                int parcelamento = scanner.nextInt();
                if (parcelamento <= 3) {
                    System.out.println("Sua compra não possui acréscimos de juros de: " + valorTotal);
                } else {
                    System.out.println("Sua compra possui um acréscimo de juros " + parcelamento + "%");
                    valorTotal = valorTotal * (100 + parcelamento) / 100;
                }
                break;
            case 2: // Boleto
                // desconto = valorTotal * 0.05; // Desconto de 5%
                valorTotal = valorTotal * 0.95;
                break;
            case 3: // PIX
                // desconto = valorTotal * 0.10; // Desconto de 10%
                valorTotal = valorTotal * 0.9;
                break;
            default:
                System.out.println("Opção inválida. Escolha uma das opções disponíveis.");
                return;
        }
        if (valorTotal >= 50) {
            System.out.println("Sua compra tem frete grátis, aproveite!! valor total de sua compra foi de: R$ " + valorTotal);
        } else {
            System.out.println("Sua compra possui um frete de R$ 10,00, valor total de sua compra foi de: R$ " + (valorTotal + 10));
        }

        System.out.println("Cupom Fiscal:");
        for (int i = 0; i < produtos.size(); i++) {
            int quantidade = carrinho.get(i);
            if (quantidade > 0) {
                Produto produto = produtos.get(i);
                System.out.println(produto.getNome() + " - R$ " + produto.getValor() + " x " + quantidade + " = R$ " + (produto.getValor() * quantidade));
            }
        }

        if (valorTotal >= 50) {
            System.out.println("Frete: Grátis");
            System.out.println("Valor total da compra: R$ " + valorTotal);
        } else {
            double valorTotalComFrete = valorTotal + 10;
            System.out.println("Frete no valor de R$ 10,00. Valor total da compra (com frete): R$ " + valorTotalComFrete);
        }
    }
}
