package Exceptions;

public class ClienteInvalidoException extends Exception {
    public ClienteInvalidoException(String message) {
        super(message);
    }

    public ClienteInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}