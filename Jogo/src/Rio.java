import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rio {
    private List<Personagem> margemDireita;
    private List<Personagem> margemEsquerda;
    private List<Personagem> barco;
    private String margemBarco;

    public Rio() {
        margemDireita = new ArrayList<>();
        margemEsquerda = new ArrayList<>();
        barco = new ArrayList<>();
        margemBarco = "Direita"; // Inicia na margem direita
    }

    public void adicionarPersonagemMargemDireita(Personagem personagem) {
        margemDireita.add(personagem);
    }

    public void adicionarPersonagemMargemEsquerda(Personagem personagem) {
        margemEsquerda.add(personagem);
    }

    public void mostrarStatus() {
        System.out.println("Margem Direita: " + margemDireita);
        System.out.println("Margem Esquerda: " + margemEsquerda);
        System.out.println("Barco: " + barco + " (Na margem " + margemBarco + ")");
    }

    public Personagem selecionarPersonagem(Class<? extends Personagem> tipo) {
        List<Personagem> margemAtual = margemBarco.equals("Direita") ? margemDireita : margemEsquerda;
        for (Personagem personagem : margemAtual) {
            if (tipo.isInstance(personagem)) {
                return personagem;
            }
        }
        return null;
    }

    public void atravessarRio(List<Personagem> personagens) {
        if (barco.isEmpty()) {
            System.out.println("O barco está vazio!");
            return;
        }
        if (margemBarco.equals("Direita")) {
            margemEsquerda.addAll(barco);
        } else {
            margemDireita.addAll(barco);
        }
        barco.clear();
        margemBarco = margemBarco.equals("Direita") ? "Esquerda" : "Direita";
    }

    public void embarcar(List<Personagem> personagens) {
        barco.addAll(personagens);
        if (margemBarco.equals("Direita")) {
            margemDireita.removeAll(personagens);
        } else {
            margemEsquerda.removeAll(personagens);
        }
    }

    public boolean verificarConflito() {
        int missionariosDireita = 0;
        int canibaisDireita = 0;
        int missionariosEsquerda = 0;
        int canibaisEsquerda = 0;

        for (Personagem p : margemDireita) {
            if (p instanceof Missionario) {
                missionariosDireita++;
            } else {
                canibaisDireita++;
            }
        }

        for (Personagem p : margemEsquerda) {
            if (p instanceof Missionario) {
                missionariosEsquerda++;
            } else {
                canibaisEsquerda++;
            }
        }

        return (missionariosDireita > 0 && canibaisDireita > missionariosDireita) ||
                (missionariosEsquerda > 0 && canibaisEsquerda > missionariosEsquerda);
    }



}