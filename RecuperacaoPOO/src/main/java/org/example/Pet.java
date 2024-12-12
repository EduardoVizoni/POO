package src.main.java.org.example;

public class Pet {

    private static int geradorCodigo;
    private int codigo;
    private String nome;
    private boolean vivo;
    private boolean acordado;
    private int fome;
    private int sede;
    private int energia;
    private int diversao;

    public Pet(String nome) {
        this.codigo = geradorCodigo++;
        this.nome = nome;
        this.vivo = true;
        this.acordado = true;
        this.fome = 100;
        this.sede = 100;
        this.energia = 100;
        this.diversao = 100;
    }

    public void comer() {
        if (vivo && acordado) fome = Math.min(fome + 20, 100);
    }

    public void beberAgua() {
        if (vivo && acordado) sede = Math.min(sede + 20, 100);
    }

    public void brincar() {
        if (vivo && acordado) {
            diversao = Math.min(diversao + 20, 100);
            energia = Math.max(energia - 10, 0);
        }
    }

    public void dormir() {
        if (vivo) {
            acordado = false;
            energia = Math.min(energia + 30, 100);
        }
    }

    public void acordar() {
        if (vivo) acordado = true;
    }

    public void limpar() {
        if (vivo) diversao = Math.min(diversao + 10, 100);
    }

    public void status() {
        System.out.println("Nome: " + nome);
        System.out.println("Vivo: " + (vivo ? "Sim" : "Não"));
        System.out.println("Acordado: " + (acordado ? "Sim" : "Não"));
        System.out.println("Fome: " + fome);
        System.out.println("Sede: " + sede);
        System.out.println("Energia: " + energia);
        System.out.println("Diversão: " + diversao);
    }

    public void morrer() {
        vivo = false;
    }

    public boolean isVivo() {
        return vivo;
    }

    public boolean isAcordado() {
        return acordado;
    }
}