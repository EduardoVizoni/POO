import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BancoEvento bancoEvento = new BancoEvento();
        BancoParticipante bancoParticipante = new BancoParticipante();
        BancoInscricao bancoInscricao = new BancoInscricao();

        while (true) {
            System.out.println("\n--- Sistema de Gestão de Eventos ---");
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Cadastrar Participante");
            System.out.println("3. Inscrever Participante em Evento");
            System.out.println("4. Remover Inscrição de Participante");
            System.out.println("5. Remover Evento");
            System.out.println("6. Exibir Todos os Eventos");
            System.out.println("7. Exibir Todos os Participantes");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEvento(scanner, bancoEvento);
                    break;
                case 2:
                    cadastrarParticipante(scanner, bancoParticipante);
                    break;
                case 3:
                    inscreverParticipante(scanner, bancoInscricao, bancoEvento, bancoParticipante);
                    break;
                case 4:
                    removerInscricao(scanner, bancoInscricao, bancoEvento, bancoParticipante);
                    break;
                case 5:
                    removerEvento(scanner, bancoEvento);
                    break;
                case 6:
                    exibirEventos(bancoEvento);
                    break;
                case 7:
                    exibirParticipantes(bancoParticipante);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void cadastrarEvento(Scanner scanner, BancoEvento bancoEvento) {
        System.out.print("Digite o nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o local do evento: ");
        String local = scanner.nextLine();
        System.out.print("Digite a data do evento: ");
        String data = scanner.nextLine();
        System.out.print("Digite a descrição do evento: ");
        String descricao = scanner.nextLine();

        Evento evento = new Evento(0, nome, local, data, descricao);
        bancoEvento.adicionarEvento(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void cadastrarParticipante(Scanner scanner, BancoParticipante bancoParticipante) {
        System.out.print("Digite o nome do participante: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do participante: ");
        String email = scanner.nextLine();

        Participante participante = new Participante(0, nome, email);
        bancoParticipante.adicionarParticipante(participante);
        System.out.println("Participante cadastrado com sucesso!");
    }

    private static void inscreverParticipante(Scanner scanner, BancoInscricao bancoInscricao, BancoEvento bancoEvento, BancoParticipante bancoParticipante) {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = bancoEvento.buscarEventoPorNome(nomeEvento);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        System.out.print("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();
        Participante participante = bancoParticipante.buscarParticipantePorEmail(nomeParticipante);

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        bancoInscricao.inscreverParticipantes(evento.getId(), participante.getId());
    }

    private static void removerInscricao(Scanner scanner, BancoInscricao bancoInscricao, BancoEvento bancoEvento, BancoParticipante bancoParticipante) {
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = bancoEvento.buscarEventoPorNome(nomeEvento);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        System.out.print("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();
        Participante participante = bancoParticipante.buscarParticipantePorEmail(nomeParticipante);

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        bancoInscricao.removerInscricao(evento.getId());
        System.out.println("Inscrição removida com sucesso!");
    }

    private static void removerEvento(Scanner scanner, BancoEvento bancoEvento) {
        System.out.print("Digite o nome do evento para remover: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = bancoEvento.buscarEventoPorNome(nomeEvento);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        bancoEvento.removerEvento(evento);
        System.out.println("Evento removido com sucesso!");
    }

    private static void exibirEventos(BancoEvento bancoEvento) {
        System.out.println("\n--- Lista de Eventos ---");
        for (Evento evento : bancoEvento.getEventos()) {
            System.out.println("ID: " + evento.getId() + " | Nome: " + evento.getNome() + " | Local: " + evento.getLocal() +
                    " | Data: " + evento.getData() + " | Descrição: " + evento.getDescricao());
        }
    }

    private static void exibirParticipantes(BancoParticipante bancoParticipante) {
        System.out.println("\n--- Lista de Participantes ---");
        for (Participante participante : bancoParticipante.getParticipantes()) {
            System.out.println("ID: " + participante.getId() + " | Nome: " + participante.getNome() + " | Email: " + participante.getEmail());
        }
    }
}
