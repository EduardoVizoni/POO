package src.main.java.org.example;

import java.util.ArrayList;

public class Banco {

    private static ArrayList<Alimento> alimentos = new ArrayList<>();
    private static ArrayList<Brincadeira> brincadeiras = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

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
        return pessoas.stream().filter(p -> p.cpf == cpf).findFirst().orElse(null);
    }

    public static Pessoa login(long cpf, String senha) {
        return pessoas.stream().filter(p -> p.cpf == cpf && p.senha.equals(senha)).findFirst().orElse(null);
    }
}