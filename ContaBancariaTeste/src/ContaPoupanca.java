public class ContaPoupanca extends ContaBancaria {
    private int meses;

    public ContaPoupanca(String numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
        this.meses = 0;
    }

    @Override
    public void calcularRendimento() {
        if (meses > 0) {
            double rendimento = saldo * 0.05 * meses;
            saldo += rendimento;
            System.out.println("Rendimento calculado para " + meses + " meses na conta " + numeroConta + ".");
            System.out.println("Rendimento: R$ " + rendimento);
            System.out.println("Novo saldo: R$ " + saldo);
            meses = 0;
        } else {
            System.out.println("Ainda não passou 1 mês para calcular o rendimento da conta " + numeroConta + ".");
        }
    }

    public void passarMeses(int meses) {
        if (meses > 0) {
            this.meses += meses;
            System.out.println(meses + " meses passaram para a conta " + numeroConta + ".");
        } else {
            System.out.println("Valor inválido para simulação de tempo.");
        }
    }
}