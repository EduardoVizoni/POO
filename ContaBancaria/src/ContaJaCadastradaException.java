public class ContaJaCadastradaException extends RuntimeException {
    public ContaJaCadastradaException() {
        super("Já existe uma conta cadastrada com o número informado!");
    }
}
