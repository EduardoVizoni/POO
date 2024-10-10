public class Entrega extends Pedido {
    private Entregador entregador;

    public Entrega(Cliente cliente, Entregador entregador) {
        super(cliente);
        this.entregador = entregador;
    }

    public Entregador getEntregador() { // Métodos auxiliares(Getters)
        return entregador;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Entrega por " + entregador;
    }
}