package trackingEncomendas;

import java.time.LocalDateTime;

public class Movimento {

    private String from;
    private String to;
    private String current;
    private int idEncomenda;
    private LocalDateTime tempoChegada;
    private boolean recebido;

    public Movimento(String from, String to, String current, int id, LocalDateTime tempo) {
        this.from = from;
        this.to = to;
        this.current = current;
        this.idEncomenda = id;
        this.tempoChegada = tempo;
        this.recebido = false;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public LocalDateTime getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(LocalDateTime tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public boolean isRecebido() {
        return recebido;
    }

    public void setRecebido(boolean recebido) {
        this.recebido = recebido;
    }


    @Override
    public String toString() {
        if (recebido == true) {
            return "Encomenda n. " + idEncomenda + " feita por " + to + " a " + from + ": " + current + " Recebida";
        } else {
            return "Encomenda n. " + idEncomenda + " feita por " + to + " a " + from + ": " + current;
        }
    }
}
