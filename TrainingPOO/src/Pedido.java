import java.util.ArrayList;

public class Pedido {
    private ArrayList<Pizza> pizzas;
    private Cliente cliente;
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.pizzas = new ArrayList<>();
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        valorTotal += pizza.calcularPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void mostrarPedido() {
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
        System.out.println("Valor Total: R$" + valorTotal);
    }
}