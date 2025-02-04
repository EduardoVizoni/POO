import Exceptions.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final CRUDConta crudConta = new CRUDConta();
    private static final CRUDCliente crudCliente = new CRUDCliente();

    public static void main(String[] args) {
        do {
            mostrarOpcoesMenu();
            int opcaoMenu = sc.nextInt();
            try {
                executarOpcaoMenu(opcaoMenu);
            } catch (ContaInexistenteException | ContaJaCadastradaException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    private static void cadastroConta() {
        CRUDConta bdConta = new CRUDConta();
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        try {
            Conta conta = crudConta.readOne(numero);
        } catch (ContaInexistenteException e) {
            System.out.println(crudCliente.readAll());


            System.out.print("Id Titular: ");
            int idTitular = sc.nextInt();

            Cliente titular = crudCliente.readOne(idTitular);

            System.out.print("Limite: ");
            double limite = sc.nextDouble();
            Conta teste = new Conta(numero, titular, limite);
            bdConta.create(teste);
            return;
        }
        throw new ContaJaCadastradaException();
    }

    private static void removeConta() {
        Conta conta = buscaConta();
        crudConta.delete(conta.getNumero());
        // db.deletarConta(numero);
    }

    private static void editaConta() {
        Conta conta = buscaConta();

        Cliente titular = buscaCliente();
        System.out.print("Limite: ");

        double limite = sc.nextDouble();
        crudConta.update(conta);
    }

    private static Conta buscaConta() {
        Conta conta = new Conta();
        System.out.println(crudConta.readAll());
        System.out.println("Número da Conta: ");
        int numero = sc.nextInt();
        return crudConta.readOne(numero);
    }

    private static Cliente buscaCliente() {
        System.out.println(crudCliente.readAll());
        System.out.println("Id do cliente: ");
        int numero = sc.nextInt();
        return crudCliente.readOne(numero);
    }

    private static void login() {
    }

    private static void logout() {
    }

    private static void mostrarDados() {
    }

    private static void mostrarOpcoesMenu() {
        System.out.print("""
                MENU:
                
                1 - Cadastro
                2 - Editar
                3 - Deletar
                4 - Mostrar Todas
                5 - Selecionar
                6 - Sair
                
                >""");
    }

    private static void mostrarOpcoesConta() {
        System.out.print("""
                OPERAÇÕES:
                
                1 - Depósito
                2 - Saque
                3 - Transferência
                4 - Saldo
                5 - Voltar
                
                >""");
    }

    private static void executarOpcaoMenu(int opcao) {
        Conta conta = new Conta();
        switch (opcao) {
            case 1 -> cadastroConta();
            case 2 -> editaConta();
            case 3 -> removeConta();
            case 4 -> System.out.println(crudConta.readAll());
            case 5 -> {
                int opcaoConta;
                try {
                    conta = buscaConta();
                } catch (ContaInexistenteException e) {
                    System.err.print(e.getMessage());
                    break;
                }
                do {
                    mostrarOpcoesConta();
                    opcaoConta = sc.nextInt();
                    do {
                        try {
                            executarOpcaoConta(conta, opcaoConta);
                            break;
                        } catch (ValorInvalidoException | ContaInexistenteException e) {
                            System.err.println(e.getMessage());
                        } catch (SaldoInsuficienteException | LimiteInsuficienteException | PropriaContaException e) {
                            System.err.println(e.getMessage());
                            break;
                        }
                    } while (true);
                } while (opcaoConta != 5);
            }
            case 6 -> {
                System.out.println("Até mais!");
                System.exit(0);
            }
            default -> System.out.println("Opção inválida");
        }
    }

    private static double solicitarValor() {
        System.out.println("Valor: R$");
        return sc.nextDouble();
    }

    private static void executarOpcaoConta(Conta conta, int opcao) {
        switch (opcao) {
            case 1 -> conta.deposito(solicitarValor());
            case 2 -> conta.saque(solicitarValor());
            case 3 -> { Conta contaBeneficiario = buscaConta();
            conta.transferencia(solicitarValor(), buscaConta());
            crudConta.update(conta);
            crudConta.update(contaBeneficiario);
            }
            /* SaldoInsuficiente, LimiteInsuficiente, PropriaConta
             * retornam para o Menu da Conta
             *  ValorInvalido, ContaInexistente solicita novamente o valor e a conta para tranferência
             */
            case 4 -> System.out.println("Saldo: R$ " + conta.getSaldo());
            case 5 -> System.out.println("Até mais!");
            default -> System.out.println("Opção inválida");
        }
    }
}