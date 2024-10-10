package Revisão_POO;

public class Quadrado extends FormaGeometrica {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado * 4;
    }

    @Override
    public String info() {
        return String.format("Quadrado - Lado: %.2f, Área: %.2f, Perímetro: %.2f",
                lado, calcularArea(), calcularPerimetro());
    }
}
