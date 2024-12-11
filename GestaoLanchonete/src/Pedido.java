import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Produto> itens;
    private String status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "Pendente";
    }

    public void adicionarItem(Produto item) {
        itens.add(item);
    }

    public void removerItem(int codigo) {
        itens.removeIf(item -> item.getCodigo() == codigo);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }
}