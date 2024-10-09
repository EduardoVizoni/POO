public class PizzaSalgada extends Pizza {

    public PizzaSalgada(String sabor, String tamanho) {
        super(sabor, tamanho);
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }
}