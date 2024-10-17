import java.util.ArrayList;
import java.util.List;

public class Rio {
    public List<Personagem> margemEsquerda;
    public List<Personagem> margemDireita;
    private List<Personagem> barco;
    private final int capacidadeBarco = 2;

    public Rio() {
        margemEsquerda = new ArrayList<>();
        margemDireita = new ArrayList<>();
        barco = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        margemEsquerda.add(personagem);
    }

    public void mostrarStatus() {
        System.out.println("Margem Esquerda: " + margemEsquerda);
        System.out.println("Margem Direita: " + margemDireita);
        System.out.println("Barco: " + barco);
    }

    public void atravessar(String margem) {
        if (margem.equalsIgnoreCase("D")) {
            if (barco.size() > 0) {
                margemDireita.addAll(barco);
            }
        } else if (margem.equalsIgnoreCase("E")) {
            if (barco.size() > 0) {
                margemEsquerda.addAll(barco);
            }
        }
        barco.clear();
    }

    public boolean verificarVitoria() {
        return margemDireita.size() == 6;
    }

    public boolean canibaisSuperamMissionarios(List<Personagem> margem) {
        int missionarios = 0;
        int canibais = 0;

        for (Personagem p : margem) {
            if (p instanceof Missionario) {
                missionarios++;
            } else if (p instanceof Canibal) {
                canibais++;
            }
        }

        return canibais > missionarios && missionarios > 0;
    }

    public void atavessar(String margem) {
    }
}
