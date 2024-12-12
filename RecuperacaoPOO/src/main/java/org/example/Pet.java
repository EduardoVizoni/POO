package src.main.java.org.example;

public class Pet {

    private int gerarCodigo;
    private String nome;
    private int sede;
    private int fome;
    private int codigo;
    private int vontadeBanheiro;
    private int higiente;
    private boolean acordado;
    private int energia;
    private boolean vivo;
    private int diversao;

    public Pet(int gerarCodigo, String nome, int sede, int fome, int codigo,
               int vontadeBanheiro, int higiente, boolean acordado,
               int energia, boolean vivo, int diversao) {
        this.gerarCodigo = gerarCodigo;
        this.nome = nome;
        this.sede = sede;
        this.fome = fome;
        this.codigo = codigo;
        this.vontadeBanheiro = vontadeBanheiro;
        this.higiente = higiente;
        this.acordado = acordado;
        this.energia = energia;
        this.vivo = vivo;
        this.diversao = diversao;
    }


    public void add(Pet pet) {
        pet.add(pet);
    }
}