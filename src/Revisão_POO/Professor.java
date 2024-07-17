package Revisão_POO;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private List<FormaGeometrica> formas;

    public Professor() {
        this.formas = new ArrayList<>();
        // Criar objetos de cada tipo
        formas.add(new Circulo(5.0));
        formas.add(new Triangulo(3.0, 4.0, 5.0));
        formas.add(new Triangulo(7.0, 7.0, 7.0));
        formas.add(new Triangulo(6.0, 6.0, 8.0));
        formas.add(new Retangulo(4.0, 6.0));
        formas.add(new Quadrado(4.0));
    }

    public void cadastrarForma(FormaGeometrica forma) {
        formas.add(forma);
        System.out.println("Forma cadastrada com sucesso!");
    }

    public void listarFormas(String tipo) {
        for (FormaGeometrica forma : formas) {
            switch (tipo) {
                case "Circulo":
                    if (forma instanceof Circulo) {
                        System.out.println(forma.info());
                    }
                    break;
                case "Triangulo":
                    if (forma instanceof Triangulo) {
                        System.out.println(forma.info());
                    }
                    break;
                case "Retangulo":
                    if (forma instanceof Retangulo) {
                        System.out.println(forma.info());
                    }
                    break;
                case "Quadrado":
                    if (forma instanceof Quadrado) {
                        System.out.println(forma.info());
                    }
                    break;
                case "Todos":
                    System.out.println(forma.info());
                    break;
                default:
                    System.out.println("Tipo inválido.");
            }
        }
    }
}
