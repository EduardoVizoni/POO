public abstract class Personagem {
    protected String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
