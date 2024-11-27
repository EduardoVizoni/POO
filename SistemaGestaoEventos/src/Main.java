public class Main {

    
    public static void main(String[] args) {
        BancoEvento banco = new BancoEvento();
        Evento evento = new Evento(1, "Papai Noel", "Santa Ceia",
                "25-12-2024", "Nascimento do Menino Jesus");


        banco.adicionarEvento(evento);
    }
}