import Exceptions.*;

public class Conta {

    private int numero;
    private Cliente titular;
    private double saldo;
    private double limite;

    public Conta() {
    }


    public Conta(int numero, Cliente titular, double saldo, double limite) {
        this(numero, titular, limite);
        this.saldo = saldo;
    }

    public Conta(int numero, Cliente titular, double limite) {
        this.numero = numero;
        this.titular = titular;
        this.limite = limite;
        this.saldo = 0;
    }

    public void saque(double valor) throws ValorInvalidoException, SaldoInsuficienteException, LimiteInsuficienteException {
        validaValor(valor);
        validaSaldo(valor);
        validaLimite(valor);
        this.saldo -= valor;
    }

    public void deposito(double valor) throws ValorInvalidoException {
        validaValor(valor);
        this.saldo += valor;
        CRUDConta crudConta = new CRUDConta();
        crudConta.update(this);
    }

    public void transferencia(double valor, Conta conta)
            throws ContaInexistenteException,
            PropriaContaException, ValorInvalidoException,
            SaldoInsuficienteException, LimiteInsuficienteException {
        validaConta(conta);
        this.saque(valor);
//      conta.saldo += valor;
        conta.deposito(valor);
    }

    private void validaValor(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException();
        }
    }

    private void validaSaldo(double valor) throws SaldoInsuficienteException {
        if (this.saldo <= valor) {
            throw new SaldoInsuficienteException();
        }
    }

    private void validaLimite(double valor) throws LimiteInsuficienteException {
        if (this.limite <= valor) {
            throw new LimiteInsuficienteException();
        }
    }

    private void validaConta(Conta conta) throws ContaInexistenteException, PropriaContaException {
        validaContaNula(conta);
        validaContaPropria(conta);
    }

    private void validaContaNula(Conta conta) throws ContaInexistenteException {
        if (conta == null) {
            throw new ContaInexistenteException();
        }
    }

    private void validaContaPropria(Conta conta) throws PropriaContaException {
        if (this == conta) {
            throw new PropriaContaException();
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public double getLimite() {
        return limite;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "\n--- Conta ---" +
                " { Número: " + numero +
                " | Titular: " + titular +
                " | Saldo: " + saldo +
                " | Limite: " + limite + "}";
    }
}