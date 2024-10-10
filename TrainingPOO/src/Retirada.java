public class Retirada extends Pedido {
    private String pontoDeRetirada;

    public Retirada(Cliente cliente, String pontoDeRetirada) {
        super(cliente);
        this.pontoDeRetirada = pontoDeRetirada;
    }

    public String getPontoDeRetirada() {
        return pontoDeRetirada;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Retirada no ponto: " + pontoDeRetirada; // Sobreposição toString
    }
}