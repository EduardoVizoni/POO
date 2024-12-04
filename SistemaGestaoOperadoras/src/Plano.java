import java.util.List;

public class Plano {

    private List<Plano> planos;

    private int id;
    private String operadora;
    private String nome;
    private double quantidade_dados;
    private double quantidade_dados_bonus;
    private String beneficios;
    private double valor;

    public Plano(int id, String operadora, String nome, double quantidade_dados, double quantidade_dados_bonus, String beneficios, double valor) {
        this.id = id;
        this.operadora = operadora;
        this.nome = nome;
        this.quantidade_dados = quantidade_dados;
        this.quantidade_dados_bonus = quantidade_dados_bonus;
        this.beneficios = beneficios;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade_dados() {
        return quantidade_dados;
    }

    public void setQuantidade_dados(double quantidade_dados) {
        this.quantidade_dados = quantidade_dados;
    }

    public double getQuantidade_dados_bonus() {
        return quantidade_dados_bonus;
    }

    public void setQuantidade_dados_bonus(double quantidade_dados_bonus) {
        this.quantidade_dados_bonus = quantidade_dados_bonus;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", operadora='" + operadora + '\'' +
                ", nome='" + nome + '\'' +
                ", quantidade_dados=" + quantidade_dados +
                ", quantidade_dados_bonus=" + quantidade_dados_bonus +
                ", beneficios='" + beneficios + '\'' +
                ", valor=" + valor +
                '}';
    }
}
