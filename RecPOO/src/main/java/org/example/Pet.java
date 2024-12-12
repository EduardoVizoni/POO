package org.example;

public class Pet {

    private static int geradorCodigo;
    private int codigo;
    private String nome;
    private boolean vivo;
    private boolean acordado;
    private int sede;
    private int fome;
    private int energia;
    private int diversao;
    private int higiene;
    private int vontadeBanheiro;

    public Pet(String nome) {
        this.codigo = geradorCodigo++;
        this.nome = nome;
        this.vivo = true;
        this.acordado = true;
        this.sede = 100;
        this.fome = 100;
        this.energia = 100;
        this.diversao = 100;
        this.higiene = 100;
        this.vontadeBanheiro = 100;
    }


    private static void add(Pet pet) {
        Pet.add(pet);
    }


    public void beberAgua() {
        if (vivo && acordado && vontadeBanheiro > 0) {
            sede = Math.min(sede + 50, 100);
            vontadeBanheiro = Math.max(vontadeBanheiro - 25, 100);
        } else {
            sede = Math.min(sede + 50, 100);
            vontadeBanheiro = Math.max(vontadeBanheiro - 25, 100);
            higiene = Math.min(higiene - 100, 100);
        }
    }

    public void comer(Alimento alimento) {
        if (vivo && acordado) fome = Math.min(fome + 50, 100);
    }

    public void dormir() {
        if (vivo) {
            acordado = false;
            energia = Math.min(energia + 25, 100);
        }
    }

    public void acordar() {
        if (vivo) acordado = true;
    }

    public void brincar(Brincadeira brincadeira) {
        if (vivo && acordado) {
            diversao = Math.min(diversao + 20, 100);
            energia = Math.max(energia - 10, 0);
        }
    }

    public void limpar() {
        if (vivo) diversao = Math.min(diversao + 10, 100);
    }

    public void fazerNecessidades() {
        if (vivo) {
            vontadeBanheiro = Math.max(vontadeBanheiro - 100, 100);
            higiene = Math.min(higiene -25, 100);
        }
    }

    public void status() {
        System.out.println("Nome: " + nome);
        System.out.println("Vivo: " + (vivo ? "Sim" : "Não"));
        System.out.println("Acordado: " + (acordado ? "Sim" : "Não"));
        System.out.println("Sede: " + sede);
        System.out.println("Fome: " + fome);
        System.out.println("Energia: " + energia);
        System.out.println("Diversão: " + diversao);
        System.out.println("Higiene: " + higiene);
        System.out.println("Banheiro: " + vontadeBanheiro);
    }

    public void morrer() {
        //if(sede == 0 || fome == 0 || energia == 0) {
        vivo = false;
    }

    public boolean isVivo() {
        return vivo;
    }

    public boolean isAcordado() {
        return acordado;
    }

    public int getCodigo() {
        return codigo;
    }

}