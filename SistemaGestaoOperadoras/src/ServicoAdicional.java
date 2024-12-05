public class ServicoAdicional {

    private int id;
    private String nome;
    private String descricao;
    private double custoMensal;

    public ServicoAdicional(int id, String nome, String descricao, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custoMensal = custoMensal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }
}
