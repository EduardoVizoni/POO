import java.sql.Date;

public class Contrato {

    private int id;
    private int id_plano;
    private String termos;
    private Date data_inicio; // dd/mm/yyyy
    private Date data_fim; // dd/mm/yyyy

    public Contrato(int id, int id_plano, String termos, Date data_inicio, Date data_fim) {
        this.id = id;
        this.id_plano = id_plano;
        this.termos = termos;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_plano() {
        return id_plano;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", id_plano=" + id_plano +
                ", termos='" + termos + '\'' +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                '}';
    }
}
