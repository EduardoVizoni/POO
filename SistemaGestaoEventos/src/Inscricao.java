

public class Inscricao {

    private int id;
    private Evento evento;
    private Participante participante;

    public Inscricao(int id, Evento evento, Participante participante) {
        this.id = id;
        this.evento = evento;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }


}
