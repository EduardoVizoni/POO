import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.numeroConta + " adicionada ao banco.");
    }

    public void removerConta(String numeroConta) {
        ContaBancaria contaRemover = buscarConta(numeroConta);
        if (contaRemover != null) {
            contas.remove(contaRemover);
            System.out.println("Conta " + numeroConta + " removida do banco.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.numeroConta.equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void mostrarRendimentos() {
        System.out.println("\n--- SALDOS E RENDIMENTOS DAS CONTAS ---");
        for (ContaBancaria conta : contas) {
            System.out.println("\nConta: " + conta.numeroConta);
            System.out.println("Saldo atual: R$ " + conta.saldo);

            if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo: Conta Poupança");
                ((ContaPoupanca) conta).calcularRendimento();
            } else {
                System.out.println("Tipo: Conta Corrente");
                System.out.println("Conta corrente não possui rendimento.");
            }
        }
    }

    public void simularTempo(int meses) {
        for (ContaBancaria conta : contas) {
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).passarMeses(meses);
            }
        }
        System.out.println("Tempo simulado: " + meses + " meses.");
    }
}