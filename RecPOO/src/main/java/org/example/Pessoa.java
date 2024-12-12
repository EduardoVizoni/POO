package org.example;

public class Pessoa {

    private long cpf;
    private String nome;
    private String senha;
    private static Pet pet;

    public Pessoa(long cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void botaPetParaDormir() {
        if (pet != null && pet.isVivo()) pet.dormir();
    }

    public void acordarPet() {
        if (pet != null && pet.isVivo()) pet.acordar();
    }

    public void adotarPet(Pet pet) {
        if (this.pet == null) this.pet = pet;
    }

    public void brincarComPet(Brincadeira brincadeira) {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.brincar(brincadeira);
    }

    public void alimentarPet(Alimento alimento) {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.comer(alimento);
    }

    public void darAguaParaPet() {
        if (pet != null && pet.isVivo() && pet.isAcordado()) pet.beberAgua();
    }

    public void levarPetParaFazerNecessidades() {
        if(pet !=null && pet.isVivo() && pet.isAcordado()) pet.fazerNecessidades();
    }

    public void limparPet() {
        if (pet != null && pet.isVivo()) pet.limpar();
    }

    public static String avaliarPet() {
        if (pet != null) pet.status();
        return null;
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