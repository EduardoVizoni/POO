package Revisão_POO;

public class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * 2 * raio;
    }

    @Override
    public String info() {
        return String.format("Circulo - Raio: %.2f, Área: %.2f, Perímetro: %.2f",
                raio, calcularArea(), calcularPerimetro());
    }
}
