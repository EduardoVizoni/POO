import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rio rio = new Rio();

        rio.adicionarPersonagemMargemDireita(new Missionario("Missionário 1"));
        rio.adicionarPersonagemMargemDireita(new Missionario("Missionário 2"));
        rio.adicionarPersonagemMargemDireita(new Missionario("Missionário 3"));
        rio.adicionarPersonagemMargemDireita(new Canibal("Canibal 1"));
        rio.adicionarPersonagemMargemDireita(new Canibal("Canibal 2"));
        rio.adicionarPersonagemMargemDireita(new Canibal("Canibal 3"));

        while (true) {
            rio.mostrarStatus();
                System.out.print("Escolha 1 ou 2 personagens para atravessar (M/C): ");
            List<Personagem> personagensSelecionados = new ArrayList<>();
            String escolha = scanner.nextLine();

            for (char c : escolha.toCharArray()) {
                Personagem personagem = c == 'M' ? rio.selecionarPersonagem(Missionario.class) : rio.selecionarPersonagem(Canibal.class);
                if (personagem != null) {
                    personagensSelecionados.add(personagem);
                } else {
                    System.out.println("Personagem não disponível.");
                }
            }

            System.out.print("Para qual margem deseja atravessar? (D: Direita, E: Esquerda): ");
            String margemDestino = scanner.nextLine().toUpperCase();

            if (margemDestino.equals("E") && !personagensSelecionados.isEmpty()) {
                rio.embarcar(personagensSelecionados);
                rio.atravessarRio(personagensSelecionados);
            } else if (margemDestino.equals("D") && !personagensSelecionados.isEmpty()) {
                rio.embarcar(personagensSelecionados);
                rio.atravessarRio(personagensSelecionados);
            }

            if (rio.verificarConflito()) {
                System.out.println("Conflito! Os canibais comeram os missionários!");
                break;
            }
        }

        scanner.close();
    }
}