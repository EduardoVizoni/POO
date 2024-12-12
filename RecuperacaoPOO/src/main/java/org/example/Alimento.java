package src.main.java.org.example;

public class Alimento {

    private String nome;
    private int geradorCodigo;
    private int nutricao;
    private int codigo;

    public Alimento(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGeradorCodigo() {
        return geradorCodigo;
    }

    public void setGeradorCodigo(int geradorCodigo) {
        this.geradorCodigo = geradorCodigo;
    }

    public int getNutricao() {
        return nutricao;
    }

    public void setNutricao(int nutricao) {
        this.nutricao = nutricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
