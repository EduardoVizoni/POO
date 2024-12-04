public class PlanoServico {

    private int id_plano;
    private int id_servico;

    public PlanoServico(int id_plano, int id_servico) {
        this.id_plano = id_plano;
        this.id_servico = id_servico;
    }

    public int getId_plano() {
        return id_plano;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    @Override
    public String toString() {
        return "PlanoServico{" +
                "id_plano=" + id_plano +
                ", id_servico=" + id_servico +
                '}';
    }
}
