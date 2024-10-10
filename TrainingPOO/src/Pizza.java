import java.util.Scanner;

public abstract class Pizza { // Abstração, Classe Abstrata
    private String sabor;
    private String tamanho;
    private double preco;

    public Pizza(String sabor, String tamanho) {
        this.sabor = sabor;
        this.tamanho = validarTamanho(tamanho);
        this.preco = definirPreco(this.tamanho);
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public abstract double calcularPreco(); // Abstração, Método Abstrato

    public static String validarTamanho(String tamanho) {
        Scanner scanner = new Scanner(System.in);
        while (!tamanho.equalsIgnoreCase("pequena") &&
                !tamanho.equalsIgnoreCase("media") &&
                !tamanho.equalsIgnoreCase("grande")) {
            System.out.println("Tamanho inválido. Digite novamente (pequena, media, grande): ");
            tamanho = scanner.nextLine();
        }
        return tamanho;
    }

    public static String validarTipoPizza(String tipoPizza) {
        Scanner scanner = new Scanner(System.in);
        while (!tipoPizza.equalsIgnoreCase("doce") &&
                !tipoPizza.equalsIgnoreCase("salgada")) {
            System.out.println("Tipo de pizza inválido. Digite novamente (doce ou salgada): ");
            tipoPizza = scanner.nextLine();
        }
        return tipoPizza;
    }

    public static double definirPreco(String tamanho) {
        switch (tamanho.toLowerCase()) {
            case "pequena":
                return 45.0;
            case "media":
                return 65.0;
            case "grande":
                return 75.0;
            default:
                return 30.0;
        }
    }

    @Override
    public String toString() {
        return "Pizza de " + sabor + " (" + tamanho + ") - Preço: R$ " + preco;
    }
}
