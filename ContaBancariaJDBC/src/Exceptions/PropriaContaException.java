package Exceptions;

public class PropriaContaException extends ContaException {

    public PropriaContaException() {
        super("Não é possível realizar a operação para a própria conta.");
    }
}
