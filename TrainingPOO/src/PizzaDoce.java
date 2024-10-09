public class PizzaDoce extends Pizza {

    public PizzaDoce(String sabor, String tamanho) {
        super(sabor, tamanho);
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }

    @Override
    public String toString() {
        return super.toString() + " (Doce)";
    }
}