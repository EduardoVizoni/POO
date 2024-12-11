import java.util.ArrayList;

public class Cliente extends Pessoa {

    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
        this.pedidos = new ArrayList<>();
    }

    public void fazerPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido adicionado com sucesso.");
    }

    public void cancelarPedido(Pedido pedido) {
        if (pedidos.remove(pedido)) {
            System.out.println("Pedido cancelado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public String visualizarPedidos() {
        if (pedidos.isEmpty()) {
            return "Nenhum pedido registrado.";
        }

        StringBuilder detalhesPedidos = new StringBuilder("Pedidos do cliente:\n");
        for (Pedido pedido : pedidos) {
            detalhesPedidos.append(pedido.toString()).append("\n----------------------\n");
        }
        return detalhesPedidos.toString();
    }
}