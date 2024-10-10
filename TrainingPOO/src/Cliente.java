public class Cliente extends Pessoa { // Classe Filha
    private String endereco; // Encapsulamento, declarando visibilidade de código
    private String telefone;

    public Cliente(String nome, String endereco, String telefone) {
        super(nome);
        this.endereco = endereco;
        this.telefone = telefone; // Abstração utilizando This
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}