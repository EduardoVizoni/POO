package Revisão_POO;

public class Triangulo extends FormaGeometrica {
    private double ladoA, ladoB, ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        if (!validarTriangulo(ladoA, ladoB, ladoC)) {
            throw new IllegalArgumentException("Medidas inválidas para um triângulo");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    private boolean validarTriangulo(double ladoA, double ladoB, double ladoC) {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    @Override
    public String info() {
        String tipo = obterTipoTriangulo();
        return String.format("Triangulo - Lados: %.2f, %.2f, %.2f, Tipo: %s, Área: %.2f, Perímetro: %.2f",
                ladoA, ladoB, ladoC, tipo, calcularArea(), calcularPerimetro());
    }

    private String obterTipoTriangulo() {
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}
