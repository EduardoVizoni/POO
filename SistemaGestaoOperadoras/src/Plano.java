public class Plano {

    private int id;
    private String operadora;
    private String nome;
    private double quantidadeDados;
    private Double quantidadeDadosBonus; // Opcional
    private String beneficios;
    private double valor;

    public Plano(int id, String operadora, String nome, double quantidadeDados, Double quantidadeDadosBonus, String beneficios, double valor) {
        this.id = id;
        this.operadora = operadora;
        this.nome = nome;
        this.quantidadeDados = quantidadeDados;
        this.quantidadeDadosBonus = quantidadeDadosBonus;
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

    public double getQuantidadeDados() {
        return quantidadeDados;
    }

    public void setQuantidadeDados(double quantidadeDados) {
        this.quantidadeDados = quantidadeDados;
    }

    public Double getQuantidadeDadosBonus() {
        return quantidadeDadosBonus;
    }

    public void setQuantidadeDadosBonus(Double quantidadeDadosBonus) {
        this.quantidadeDadosBonus = quantidadeDadosBonus;
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
}