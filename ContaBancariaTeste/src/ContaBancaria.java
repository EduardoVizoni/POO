public abstract class ContaBancaria {
    protected String numeroConta;
    protected double saldo;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public abstract void calcularRendimento();

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor insuficiente para depositar.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        }
        else {
            System.out.println("Valor insuficiente para sacar.");
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        if (contaDestino != null && valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
        } else {
            System.out.println("Valor insuficiente para transferir.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Seu saldo atual: R$ " + this.saldo);

    }
}
