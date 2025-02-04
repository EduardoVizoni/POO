public abstract class ContaBancaria {
    protected String numeroConta;
    protected double saldo;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public abstract void calcularRendimento();

    public double depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
        else {
            System.out.println("Valor insuficiente para depositar.");
        }
        return valor;
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        }
        else {
            System.out.println("Valor insuficiente para sacar.");
        }
    }

    public double transferir(double valor, ContaBancaria contaDestino) {
        if (contaDestino != null && valor > 0 && this.saldo >= valor) {
            contaDestino.saldo += valor;
        }
        else {
            System.out.println("Valor insuficiente para transferir.");
        }
        return valor;
    }

    public void exibirSaldo() {
        System.out.println("Seu saldo atual: R$ " + this.saldo);

    }
}
