import java.util.Objects;

public abstract class Personagem {
    protected String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personagem that = (Personagem) obj;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
