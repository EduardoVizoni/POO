package Exceptions;

public class ServicoAdicionalInvalidoException extends Exception {
  public ServicoAdicionalInvalidoException(String message) {
    super(message);
  }

  public ServicoAdicionalInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }
}
