package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Banco {

    private static ArrayList<Alimento> alimentos = new ArrayList<>();
    private static ArrayList<Brincadeira> brincadeiras = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Banco() {
    }

    public static void setAlimentos(ArrayList<Alimento> alimentos) {
        Banco.alimentos = alimentos;
    }

    public static void setBrincadeiras(ArrayList<Brincadeira> brincadeiras) {
        Banco.brincadeiras = brincadeiras;
    }

    public static void setPets(ArrayList<Pet> pets) {
        Banco.pets = pets;
    }

    public static ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public static ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public static ArrayList<Brincadeira> getBrincadeiras() {
        return brincadeiras;
    }

    public static void setPessoas(ArrayList<Pessoa> pessoas) {
        Banco.pessoas = pessoas;
    }

    public static void cadastrarPet(Pet pet) {
        pets.add(pet);
    }

    public static void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static void cadastrarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public static void cadastrarBrincadeira(Brincadeira brincadeira) {
        brincadeiras.add(brincadeira);
    }

    public static Alimento procurarAlimento(int codigo) {
        return alimentos.stream().filter(a -> a.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static Brincadeira procurarBrincadeira(int codigo) {
        return brincadeiras.stream().filter(b -> b.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static Pet procurarPet(int codigo) {
        return pets.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    public static Pessoa procurarPessoa(long cpf) {
        return pessoas.stream().filter(p -> p.getCpf() == cpf).findFirst().orElse(null);
    }

    public static Pessoa login(long cpf, String senha) {
        return pessoas.stream().filter(p -> p.getCpf() == cpf && p.getSenha().equals(senha)).findFirst().orElse(null);
    }

    public static Collection<Object> getPets() {
        return null;
    }

    public static void removerPet(Pet pet) {
    }

    public static void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

}