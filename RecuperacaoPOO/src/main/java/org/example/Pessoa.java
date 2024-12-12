package src.main.java.org.example;

public class Pessoa {
    
    private long cpf;
    private String nome;
    private String senha;
    private Pet pet;

    public Pessoa(long cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public void adotarPet(Pet pet) {
        if (this.pet == null) this.pet = pet;
    }

    public void alimentarPet() {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.comer();
    }

    public void darAguaParaPet() {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.beberAgua();
    }

    public void brincarComPet() {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.brincar();
    }

    public void botaPetParaDormir() {
        if (pet != null && pet.isVivo()) pet.dormir();
    }

    public void acordarPet() {
        if (pet != null && pet.isVivo()) pet.acordar();
    }

    public void limparPet() {
        if (pet != null && pet.isVivo()) pet.limpar();
    }

    public void avaliarPet() {
        if (pet != null) pet.status();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "CPF=" + cpf +
                ", Nome='" + nome + '\'' +
                ", Pet=" + (pet != null ? pet.toString() : "Nenhum") +
                '}';
    }
}
