package Revisão_POO;

public class Retangulo extends FormaGeometrica {
    private double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    @Override
    public String info() {
        return String.format("Retângulo - Largura: %.2f, Altura: %.2f, Área: %.2f, Perímetro: %.2f",
                largura, altura, calcularArea(), calcularPerimetro());
    }
}
