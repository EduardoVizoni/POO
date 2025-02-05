import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Remover Conta");
            System.out.println("3. Acessar Conta");
            System.out.println("4. Mostrar Rendimentos de Todas as Contas");
            System.out.println("5. Simular Passagem do Tempo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                System.out.println("\n--- CADASTRAR CONTA ---");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    System.out.print("Escolha o tipo de conta: ");
                    int tipoConta = scanner.nextInt();

                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.next();
                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    if (tipoConta == 1) {
                        ContaCorrente cc = new ContaCorrente(numeroConta, saldoInicial);
                        banco.adicionarConta(cc);
                    } else if (tipoConta == 2) {
                        ContaPoupanca cp = new ContaPoupanca(numeroConta, saldoInicial);
                        banco.adicionarConta(cp);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.print("\nDigite o número da conta a ser removida: ");
                    String numeroRemover = scanner.next();
                    banco.removerConta(numeroRemover);
                    break;

                case 3:
                    System.out.print("\nDigite o número da conta para acessar: ");
                    String numeroAcessar = scanner.next();
                    ContaBancaria contaAcessar = banco.buscarConta(numeroAcessar);

                    if (contaAcessar != null) {
                        while (true) {
                            System.out.println("\n--- GERENCIAR CONTA (" + contaAcessar.numeroConta + ") ---");
                            System.out.println("1. Depositar");
                            System.out.println("2. Sacar");
                            System.out.println("3. Transferir");
                            System.out.println("4. Ver Saldo");
                            if (contaAcessar instanceof ContaPoupanca) {
                                System.out.println("5. Calcular Rendimento");
                            }
                            System.out.println("6. Voltar ao Menu Principal");
                            System.out.print("Escolha uma opção: ");
                            int opcaoGerenciar = scanner.nextInt();

                            switch (opcaoGerenciar) {
                                case 1:
                                    System.out.print("Digite o valor a depositar: ");
                                    double valorDeposito = scanner.nextDouble();
                                    contaAcessar.depositar(valorDeposito);
                                    break;

                                case 2:
                                    System.out.print("Digite o valor a sacar: ");
                                    double valorSaque = scanner.nextDouble();
                                    contaAcessar.sacar(valorSaque);
                                    break;

                                case 3:
                                    System.out.print("Digite o número da conta de destino: ");
                                    String numeroDestino = scanner.next();
                                    ContaBancaria contaDestino = banco.buscarConta(numeroDestino);

                                    if (contaDestino != null) {
                                        System.out.print("Digite o valor a transferir: ");
                                        double valorTransferencia = scanner.nextDouble();
                                        contaAcessar.transferir(valorTransferencia, contaDestino);
                                    } else {
                                        System.out.println("Conta de destino não encontrada.");
                                    }
                                    break;

                                case 4:
                                    contaAcessar.exibirSaldo();
                                    break;

                                case 5:
                                    if (contaAcessar instanceof ContaPoupanca) {
                                        ((ContaPoupanca) contaAcessar).calcularRendimento();
                                    } else {
                                        System.out.println("Esta operação é válida apenas para contas poupança.");
                                    }
                                    break;

                                case 6:
                                    System.out.println("Retornando ao menu principal...");
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }

                            if (opcaoGerenciar == 6) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- RENDIMENTOS DE TODAS AS CONTAS ---");
                    banco.mostrarRendimentos();
                    break;

                case 5:
                    System.out.print("\nDigite o número de meses a simular: ");
                    int meses = scanner.nextInt();
                    banco.simularTempo(meses);
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}