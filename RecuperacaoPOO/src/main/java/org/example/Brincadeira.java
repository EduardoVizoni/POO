package src.main.java.org.example;

public class Brincadeira {

    private static int geradorCodigo = 1;
    private int codigo;
    private String nome;
    private int divertimento;
    private int cansaco;
    private int fome;
    private int sede;
    private int sujeira;

    public Brincadeira(String nome, int divertimento, int cansaco, int fome, int sede, int sujeira) {
        this.codigo = geradorCodigo++;
        this.nome = nome;
        this.divertimento = divertimento;
        this.cansaco = cansaco;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getDivertimento() {
        return divertimento;
    }

    public int getCansaco() {
        return cansaco;
    }

    public int getFome() {
        return fome;
    }

    public int getSede() {
        return sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    @Override
    public String toString() {
        return "Brincadeira{" +
                "Código=" + codigo +
                ", Nome='" + nome + '\'' +
                ", Divertimento=" + divertimento +
                ", Cansaço=" + cansaco +
                ", Fome=" + fome +
                ", Sede=" + sede +
                ", Sujeira=" + sujeira +
                '}';
    }
}