class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        double rendimento = saldo * 0.05;
        saldo += rendimento;
        System.out.println("Rendimento de 5% aplicado. " + "\nNovo saldo: R$ " + saldo);
    }
}