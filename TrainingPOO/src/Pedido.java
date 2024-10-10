import java.util.ArrayList;

public class Pedido {
    private ArrayList<Pizza> pizzas;
    private Cliente cliente; // Atributos
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.pizzas = new ArrayList<>();
    }

    public void adicionarPizza(Pizza pizza) { // Método
        pizzas.add(pizza);
        valorTotal += pizza.calcularPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void mostrarPedido() { // For-each
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
        System.out.println("Valor Total: R$" + valorTotal);
    }
}