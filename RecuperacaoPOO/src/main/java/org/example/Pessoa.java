package src.main.java.org.example;

public class Pessoa {

    private String senha;
    private Pet pet;
    private String nome;
    private long cpf;

    public Pessoa(String senha, Pet pet, String nome, long cpf) {
        this.senha = senha;
        this.pet = pet;
        this.nome = nome;
        this.cpf = cpf;
    }

    public void add(Pessoa pessoa) {
        pessoa.add(pessoa);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void botaPetParaDormir() {

    }
}
