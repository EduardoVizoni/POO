public class Main {
    public static void main(String[] args) {

        Produto lanche = new Lanche(1, "Lanche de Carne", 20.0, 0.5);
        Produto bebida = new Bebida(2, "Suco de Laranja", 5.0, 1.0);
        Produto outro = new Outro(3, "Batata Frita", 7.0, "Médio");

        Cliente cliente = new Cliente("João", "Rua A", "1234-5678");
        Garcom garcom = new Garcom("Carlos", "Rua B", "9876-5432");

        Pedido pedido = new Pedido(cliente);

        garcom.adicionarItemAoPedido(pedido, lanche);
        garcom.adicionarItemAoPedido(pedido, bebida);
        garcom.adicionarItemAoPedido(pedido, outro);

        System.out.println("\nDetalhes do Pedido:");
        for (Produto item : pedido.getItens()) {
            System.out.println(item.exibirDetalhes());
        }

        System.out.println("\nTotal do pedido: R$ " + pedido.calcularTotal());

        garcom.confirmarPedido(pedido);

        double pagamentoGarcom = garcom.calcularPagamento(pedido);
        System.out.println("\nPagamento do garçom: R$ " + pagamentoGarcom);

        System.out.println("\nPedidos realizados por " + cliente.getNome() + ":");
        System.out.println(cliente.visualizarPedidos());
    }
}