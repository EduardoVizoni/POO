public class Outro extends Produto {

    private String tamanho;

    public Outro(int codigo, String descricao, double preco, String tamanho) {
        super(codigo, descricao, preco);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public double calcularPreco(double desconto) {
        return getPreco() - (getPreco() * desconto / 100);
    }

    @Override
    public String exibirDetalhes() {
        return "";
    }
}
