import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeCardapio {

    private ArrayList<Produto> cardapio;

    public GerenciadorDeCardapio() {
        this.cardapio = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tem certeza que deseja adicionar o produto " + produto.getDescricao() + " ao cardápio? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            for (Produto p : cardapio) {
                if (p.getCodigo() == produto.getCodigo()) {
                    System.out.println("Produto com esse código já existe no cardápio.");
                    return;
                }
            }
            cardapio.add(produto);
            System.out.println("Produto adicionado com sucesso.");
        } else {
            System.out.println("Produto não foi adicionado.");
        }
    }

    public void removerProduto(int codigo) {
        Scanner scanner = new Scanner(System.in);
        Produto produtoRemovido = null;

        for (Produto produto : cardapio) {
            if (produto.getCodigo() == codigo) {
                produtoRemovido = produto;
                break;
            }
        }

        if (produtoRemovido != null) {
            System.out.print("Tem certeza que deseja remover o produto " + produtoRemovido.getDescricao() + "? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                cardapio.remove(produtoRemovido);
                System.out.println("Produto removido com sucesso.");
            } else {
                System.out.println("Produto não foi removido.");
            }
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }

    public ArrayList<Produto> listarProdutos() {
        return cardapio;
    }

    public double calcularPrecoTotal(Pedido pedido) {
        double total = 0;
        for (Produto produto : pedido.getItens()) {
            total += produto.getPreco();
        }
        return total;
    }

    public double calcularPagamento(Garcom garcom, Pedido pedido) {
        double totalPedido = calcularPrecoTotal(pedido);
        return totalPedido * 0.05 + totalPedido;
    }

    public double calcularDescontoCombo(Pedido pedido) {
        int quantidadeItens = pedido.getItens().size();
        double desconto = 0;

        if (quantidadeItens == 2) {
            desconto = 0.05;
        } else if (quantidadeItens == 3) {
            desconto = 0.10;
        } else if (quantidadeItens >= 4) {
            desconto = 0.15;
        }

        return desconto;
    }
}