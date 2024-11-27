import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static BancoEvento bancoEvento = new BancoEvento();
    private static BancoParticipante bancoParticipante = new BancoParticipante();
    private static BancoInscricao bancoInscricao = new BancoInscricao();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Sistema de Gestão de Eventos");
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Cadastrar Participante");
            System.out.println("3. Inscrever Participante em Evento");
            System.out.println("4. Buscar Evento por Nome");
            System.out.println("5. Buscar Participante por Email");
            System.out.println("6. Remover Inscrição");
            System.out.println("7. Remover Evento");
            System.out.println("8. Ver Todos os Eventos");
            System.out.println("9. Ver Todos os Participantes");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    cadastrarParticipante();
                    break;
                case 3:
                    inscreverParticipante();
                    break;
                case 4:
                    buscarEventoPorNome();
                    break;
                case 5:
                    buscarParticipantePorEmail();
                    break;
                case 6:
                    removerInscricao();
                    break;
                case 7:
                    removerEvento();
                    break;
                case 8:
                    verTodosEventos();
                    break;
                case 9:
                    verTodosParticipantes();
                    break;
                case 10:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarEvento() {
        System.out.print("Informe o nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o local do evento: ");
        String local = scanner.nextLine();
        System.out.print("Informe a data do evento (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Informe a descrição do evento: ");
        String descricao = scanner.nextLine();

        Evento evento = new Evento(0, nome, local, data, descricao);
        bancoEvento.adicionarEvento(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void cadastrarParticipante() {
        System.out.print("Informe o nome do participante: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o email do participante: ");
        String email = scanner.nextLine();

        Participante participante = new Participante(0, nome, email);
        bancoParticipante.adicionarParticipante(participante);
        System.out.println("Participante cadastrado com sucesso!");
    }

    private static void inscreverParticipante() {
        System.out.print("Informe o ID do evento: ");
        int eventoId = scanner.nextInt();
        System.out.print("Informe o ID do participante: ");
        int participanteId = scanner.nextInt();

        bancoInscricao.inscreverParticipantes(eventoId, participanteId);
    }

    private static void buscarEventoPorNome() {
        System.out.print("Informe o nome do evento: ");
        String nome = scanner.nextLine();

        Evento evento = bancoEvento.buscarEventoPorNome(nome);
        if (evento != null) {
            System.out.println("Evento encontrado: " + evento.getNome() + " | Local: " + evento.getLocal());
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void buscarParticipantePorEmail() {
        System.out.print("Informe o email do participante: ");
        String email = scanner.nextLine();

        Participante participante = bancoParticipante.buscarParticipantePorEmail(email);
        if (participante != null) {
            System.out.println("Participante encontrado: " + participante.getNome());
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private static void removerInscricao() {
        System.out.print("Informe o ID da inscrição a ser removida: ");
        int id = scanner.nextInt();

        bancoInscricao.removerInscricao(id);
        System.out.println("Inscrição removida com sucesso!");
    }

    private static void removerEvento() {
        System.out.print("Informe o ID do evento a ser removido: ");
        int eventoId = scanner.nextInt();

        Evento evento = new Evento(eventoId, "", "", "", "");
        bancoEvento.removerEvento(evento);
        System.out.println("Evento removido com sucesso!");
    }

    private static void verTodosEventos() {
        System.out.println("Lista de Todos os Eventos:");
        List<Evento> eventos = bancoEvento.getEventos(); // Assumindo que você tem um método `getEventos` para obter todos os eventos
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            for (Evento evento : eventos) {
                System.out.println("ID: " + evento.getId() + " | Nome: " + evento.getNome() + " | Local: " + evento.getLocal() + " | Data: " + evento.getData() + " | Descrição: " + evento.getDescricao());
            }
        }
    }

    private static void verTodosParticipantes() {
        System.out.println("Lista de Todos os Participantes:");
        List<Participante> participantes = bancoParticipante.getParticipantes(); // Assumindo que você tem um método `getParticipantes` para obter todos os participantes
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante encontrado.");
        } else {
            for (Participante participante : participantes) {
                System.out.println("ID: " + participante.getId() + " | Nome: " + participante.getNome() + " | Email: " + participante.getEmail());
            }
        }
    }
}
