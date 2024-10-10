//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta(1, "Romário", 80000, 50000);
        Conta conta2 = new Conta(2, "Kristian", 54000, 30000);

        try {
            conta1.saque(90000000);
        } catch (SaldoInsuficienteException  exception) {
            System.out.println(exception.getMessage());
        } catch (LimiteInsuficienteException | ValorInvalidoException exception) {
            exception.printStackTrace(); // O método printStackTrace() serve para exibir o conteúdo da pilha de execução quando ocorre uma exceção.
        } catch (ContaException ignore) {}


        System.out.println("Ainda está rodando");

    }
}