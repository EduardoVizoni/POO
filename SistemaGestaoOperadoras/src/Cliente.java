import java.util.List;

public class Cliente {

    private List<Cliente> clientes;
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int id_plano;

    public Cliente(int id, String nome, String email, String telefone, int id_plano) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id_plano = id_plano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId_plano() {
        return id_plano;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", id_plano=" + id_plano +
                '}';
    }
}
