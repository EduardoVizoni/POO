import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<ContaBancaria> contas;


    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.numeroConta + " adicionada ao banco.");
    }

    public void removerConta(ContaBancaria conta) {
        contas.remove(conta);
        System.out.println("Conta " + conta.numeroConta + " removida ao banco.");
    }

    public void realizarOperacoes() {
        for (ContaBancaria conta : contas) {
            conta.exibirSaldo();
            conta.calcularRendimento();
        }
    }
}