public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();


        ContaCorrente cc = new ContaCorrente("Corrente", 500);
        ContaPoupanca cp = new ContaPoupanca("Poupança", 1500);

        banco.adicionarConta(cc);
        banco.adicionarConta(cp);

        cc.depositar(500);
        cc.sacar(200);
        cc.transferir(300, cp);

        banco.realizarOperacoes();
    }
}
