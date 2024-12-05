public class Contrato {

    private int id;
    private int idPlano;
    private String termos;
    private String dataInicio;
    private String dataFim;
    private double custoMensal;

    public Contrato(int id, int idPlano, String termos, String dataInicio, String dataFim, double custoMensal) {
        this.id = id;
        this.idPlano = idPlano;
        this.termos = termos;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.custoMensal = custoMensal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }
}
