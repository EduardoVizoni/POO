public class Garcom extends Pessoa {

    private double pagamento;

    public Garcom(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
        this.pagamento = 0.0;
    }

    public void cadastrarPedido(Cliente cliente, Pedido pedido) {
        cliente.fazerPedido(pedido);
        System.out.println("Pedido registrado para o cliente " + cliente.getNome());
    }

    public String exibirMenu() {
        return "Menu disponível: 1. Produto A 2. Produto B 3. Produto C";
    }

    public void adicionarItemAoPedido(Pedido pedido, Produto item) {
        pedido.adicionarItem(item);
        System.out.println("Item adicionado ao pedido.");
    }

    public void removerItemDoPedido(Pedido pedido, int codigo) {
        pedido.removerItem(codigo);
        System.out.println("Item removido do pedido.");
    }

    public void confirmarPedido(Pedido pedido) {
        double total = pedido.calcularTotal();
        System.out.println("Pedido confirmado. Total: R$ " + total);
    }

    public double calcularPagamento(Pedido pedido) {
        double totalPedido = pedido.calcularTotal();
        pagamento += totalPedido * 0.05;
        return pagamento;
    }
}