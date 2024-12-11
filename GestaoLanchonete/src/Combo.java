import java.util.ArrayList;

public class Combo extends Produto {

    private ArrayList<Produto> produtos;
    private double desconto;

    public Combo(int codigo, String descricao, double preco, double desconto) {
        super(codigo, descricao, preco);
        this.produtos = new ArrayList<>();
        this.desconto = desconto;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double calcularDesconto() {
        double totalProdutos = 0;
        for (Produto produto : produtos) {
            totalProdutos += produto.getPreco();
        }
        return totalProdutos * (desconto / 100);
    }

    @Override
    public double calcularPreco(double desconto) {
        double totalProdutos = 0;
        for (Produto produto : produtos) {
            totalProdutos += produto.getPreco();
        }
        double descontoCalculado = totalProdutos * (this.desconto / 100);
        return totalProdutos - descontoCalculado;
    }

    @Override
    public String exibirDetalhes() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Código: ").append(getCodigo())
                .append("\nDescrição: ").append(getDescricao())
                .append("\nPreço original: R$ ").append(getPreco())
                .append("\nDesconto: ").append(desconto).append("%\n");
        detalhes.append("Produtos no combo:\n");

        for (Produto produto : produtos) {
            detalhes.append(produto.getDescricao()).append(" - R$ ").append(produto.getPreco()).append("\n");
        }
        detalhes.append("Preço com desconto: R$ ").append(calcularPreco(desconto));
        return detalhes.toString();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}