public class Bebida extends Produto{

    private double volume;

    public Bebida(int codigo, String descricao, double preco, double volume) {
        super(codigo, descricao, preco);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
                "\nVolume: " + volume + " L";
    }
}

