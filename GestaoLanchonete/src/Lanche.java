public class Lanche extends Produto {

    private double peso;

    public Lanche(int codigo, String descricao, double preco, double peso) {
        super(codigo, descricao, preco);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calcularPreco(double desconto) {
        return getPreco() - (getPreco() * desconto / 100);
    }

    @Override
    public String exibirDetalhes() {
        return "Código: " + getCodigo() +
                "\nDescrição: " + getDescricao() +
                "\nPreço: R$ " + getPreco() +
                "\nPeso: " + peso + " kg";
    }


}
