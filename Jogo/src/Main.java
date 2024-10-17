import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rio rio = new Rio();
        Scanner scanner = new Scanner(System.in);
        List<Personagem> barco = new ArrayList<>();

        rio.adicionarPersonagem(new Missionario("Missionário 1"));
        rio.adicionarPersonagem(new Canibal("Canibal 1"));
        rio.adicionarPersonagem(new Missionario("Missionário 2"));
        rio.adicionarPersonagem(new Canibal("Canibal 2"));
        rio.adicionarPersonagem(new Missionario("Missionário 3"));
        rio.adicionarPersonagem(new Canibal("Canibal 3"));

        while (true) {
            rio.mostrarStatus();

            System.out.print("Escolha 1 ou 2 personagens para atravessar (M/C): ");
            String escolha = scanner.nextLine();

            if (!escolha.equals("M") && !escolha.equals("C") && !escolha.equals("MM") && !escolha.equals("CC") && !escolha.equals("MC")) {
                System.out.println("Escolha inválida!");
                continue;
            }

            barco.clear();
            if (escolha.equals("M")) {
                barco.add(new Missionario("Missionário"));
            } else if (escolha.equals("C")) {
                barco.add(new Canibal("Canibal"));
            } else if (escolha.equals("MM")) {
                barco.add(new Missionario("Missionário"));
                barco.add(new Missionario("Missionário"));
            } else if (escolha.equals("CC")) {
                barco.add(new Canibal("Canibal"));
                barco.add(new Canibal("Canibal"));
            } else if (escolha.equals("MC")) {
                barco.add(new Missionario("Missionário"));
                barco.add(new Canibal("Canibal"));
            }

            System.out.print("Para qual margem deseja atravessar? (D: Direita, E: Esquerda): ");
            String margem = scanner.nextLine();
            rio.atavessar(margem);

            if (rio.canibaisSuperamMissionarios(rio.margemEsquerda) || rio.canibaisSuperamMissionarios(rio.margemDireita)) {
                System.out.println("Você perdeu! Os canibais comeram os missionários!");
                break;
            }

            if (rio.verificarVitoria()) {
                System.out.println("Você ganhou! Todos os missionários e canibais chegaram ao outro lado!");
                break;
            }
        }

        scanner.close();
    }
}