package src.main.java.org.example;

public class Brincadeira {

    private int codigo;
    private int gerarCodigo;
    private String nome;
    private int cansaco;
    private int fome;
    private int sede;
    private int sujeira;
    private int divertimento;

    public Brincadeira(int codigo, int gerarCodigo, String nome, int cansaco,
                       int fome, int sede, int sujeira, int divertimento) {
        this.codigo = codigo;
        this.gerarCodigo = gerarCodigo;
        this.nome = nome;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
        this.divertimento = divertimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCansaco() {
        return cansaco;
    }

    public void setCansaco(int cansaco) {
        this.cansaco = cansaco;
    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    public void setSujeira(int sujeira) {
        this.sujeira = sujeira;
    }

    public int getDivertimento() {
        return divertimento;
    }

    public void setDivertimento(int divertimento) {
        this.divertimento = divertimento;
    }
}
