package src.main.java.org.example;

public class Pet {


    public static boolean getAcordado;
    public static boolean setAcordado;
    private int gerarCodigo;
    private String nome;
    private int sede;
    private int fome;
    private int codigo;
    private int vontadeBanheiro;
    private int higiene;
    private boolean acordado;
    private int energia;
    private boolean vivo;
    private int diversao;

    public Pet(int gerarCodigo, String nome, int sede, int fome, int codigo,
               int vontadeBanheiro, int higiene, boolean acordado,
               int energia, boolean vivo, int diversao) {
        this.gerarCodigo = gerarCodigo;
        this.nome = nome;
        this.sede = sede;
        this.fome = fome;
        this.codigo = codigo;
        this.vontadeBanheiro = vontadeBanheiro;
        this.higiene = higiene;
        this.acordado = acordado;
        this.energia = energia;
        this.vivo = vivo;
        this.diversao = diversao;
    }

    public void add(Pet pet) {
        pet.add(pet);
        System.out.println("Pet adicionado com sucesso!");
    }

    public int beberAgua() {
        if (vontadeBanheiro == 0) {
            return (higiene - 100) & (sede + 50);
        } else {
            return (sede + 50) & (vontadeBanheiro - 25);
        }
    }

    public void comer(Alimento alimento) {
        return n
    }

    public boolean isAcordado() {
        return acordado;
    }

    public void setAcordado(boolean acordado) {
        this.acordado = acordado;
    }
}