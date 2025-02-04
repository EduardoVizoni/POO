public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        // Conta corrente não tem rendimento
        System.out.println("Conta corrente não possui rendimento.");
    }
}
