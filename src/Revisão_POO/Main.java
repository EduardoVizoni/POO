package Revisão_POO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Professor professor = new Professor();
        LogIn login = new LogIn();

        login.setUser("Professor");
        login.setSenha("#Euamogeometria123");

        if (!autenticar(login, scanner)) {
            return;
        }

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Cadastrar forma");
            System.out.println("2. Listar formas");
            System.out.println("3. Logout");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarForma(professor, scanner);
                    break;
                case 2:
                    listarFormas(professor, scanner);
                    break;
                case 3:
                    if (autenticar(login, scanner)) {
                        return;
                    } else {
                        return;
                    }
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static boolean autenticar(LogIn login, Scanner scanner) {
        int tentativas = 0;
        while (tentativas < 3) {
            System.out.print("Insira o usuário: ");
            String user = scanner.nextLine();
            System.out.print("Insira a senha: ");
            String senha = scanner.nextLine();

            if (login.getUser().equals(user) && login.getSenha().equals(senha)) {
                return true;
            } else {
                System.out.println("Usuário ou senha incorretos. Tente novamente.");
                tentativas++;
            }
        }
        System.out.println("Número máximo de tentativas atingido.");
        return false;
    }

    private static void cadastrarForma(Professor professor, Scanner scanner) {
        System.out.println("Escolha o tipo de forma para cadastrar:");
        System.out.println("1. Círculo");
        System.out.println("2. Triângulo");
        System.out.println("3. Retângulo");
        System.out.println("4. Quadrado");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Insira o raio do círculo: ");
                double raio = scanner.nextDouble();
                professor.cadastrarForma(new Circulo(raio));
                break;
            case 2:
                System.out.print("Insira os lados do triângulo (separados por espaço): ");
                double ladoA = scanner.nextDouble();
                double ladoB = scanner.nextDouble();
                double ladoC = scanner.nextDouble();
                try {
                    professor.cadastrarForma(new Triangulo(ladoA, ladoB, ladoC));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.print("Insira a largura e altura do retângulo (separados por espaço): ");
                double largura = scanner.nextDouble();
                double altura = scanner.nextDouble();
                professor.cadastrarForma(new Retangulo(largura, altura));
                break;
            case 4:
                System.out.print("Insira o lado do quadrado: ");
                double lado = scanner.nextDouble();
                professor.cadastrarForma(new Quadrado(lado));
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void listarFormas(Professor professor, Scanner scanner) {
        System.out.println("Escolha o tipo de forma para listar:");
        System.out.println("1. Círculos");
        System.out.println("2. Triângulos");
        System.out.println("3. Retângulos");
        System.out.println("4. Quadrados");
        System.out.println("5. Todos");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

        switch (opcao) {
            case 1:
                professor.listarFormas("Circulo");
                break;
            case 2:
                professor.listarFormas("Triangulo");
                break;
            case 3:
                professor.listarFormas("Retangulo");
                break;
            case 4:
                professor.listarFormas("Quadrado");
                break;
            case 5:
                professor.listarFormas("Todos");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}