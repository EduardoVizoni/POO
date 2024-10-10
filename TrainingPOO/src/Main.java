import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String enderecoCliente = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefoneCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente);

        ArrayList<Pizza> pizzas = new ArrayList<>();
        String adicionarPizza = "sim";

        while (normalizarResposta(adicionarPizza).equalsIgnoreCase("sim")) {
            System.out.print("A pizza é doce ou salgada? ");
            String tipoPizza = scanner.nextLine();
            tipoPizza = Pizza.validarTipoPizza(normalizarResposta(tipoPizza));

            System.out.print("Digite o sabor da pizza: ");
            String sabor = scanner.nextLine();

            System.out.print("Digite o tamanho da pizza (pequena/media/grande): ");
            String tamanho = scanner.nextLine();
            tamanho = Pizza.validarTamanho(normalizarResposta(tamanho));

            if (normalizarResposta(tipoPizza).equalsIgnoreCase("doce")) {
                pizzas.add(new PizzaDoce(sabor, tamanho));
            } else {
                pizzas.add(new PizzaSalgada(sabor, tamanho));
            }

            System.out.print("Deseja adicionar mais uma pizza? (sim/não): ");
            adicionarPizza = scanner.nextLine();
        }

        System.out.print("O pedido será para entrega? (sim/não): ");
        String entrega = scanner.nextLine();
        Pedido pedido;

        if (normalizarResposta(entrega).equalsIgnoreCase("sim")) {
            System.out.print("Digite o nome do entregador: ");
            String nomeEntregador = scanner.nextLine();
            System.out.print("Digite o veículo do entregador: ");
            String veiculoEntregador = scanner.nextLine();
            System.out.print("Digite o tempo estimado de entrega (em minutos): ");
            int tempoEntrega = scanner.nextInt();

            Entregador entregador = new Entregador(nomeEntregador, veiculoEntregador, tempoEntrega);
            pedido = new Entrega(cliente, entregador);
        } else {
            System.out.print("Digite o ponto de retirada: ");
            String pontoRetirada = scanner.nextLine();
            pedido = new Retirada(cliente, pontoRetirada);
        }

        for (Pizza pizza : pizzas) {
            pedido.adicionarPizza(pizza);
        }

        System.out.println("\n--- Detalhes do Pedido ---");
        System.out.println("------ Nota Fiscal ------");
        pedido.mostrarPedido();
        System.out.println(pedido);
    }

    public static String normalizarResposta(String input) {
        return input.toLowerCase()
                .replace("á", "a")
                .replace("ã", "a")
                .replace("é", "e")
                .replace("ê", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("õ", "o")
                .replace("ú", "u")
                .replace("ç", "c");
    }
}