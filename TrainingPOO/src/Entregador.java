public class Entregador extends Pessoa {
    private String veiculo;
    private int tempoEstimadoEntrega; // minutos

    public Entregador(String nome, String veiculo, int tempoEstimadoEntrega) { // Método Construtor
        super(nome);
        this.veiculo = veiculo;
        this.tempoEstimadoEntrega = tempoEstimadoEntrega;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public int getTempoEstimadoEntrega() {
        return tempoEstimadoEntrega;
    }

    @Override // Sobrescrita
    public String toString() { // toString
        return "Entregador: " + getNome() + ", Veículo: " + veiculo + ", Tempo estimado de entrega: " + tempoEstimadoEntrega + " minutos.";
    }
}