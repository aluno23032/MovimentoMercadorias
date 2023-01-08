package trackingEncomendas;

import java.time.LocalDateTime;

public class Movimento {

    private String from;
    private String to;
    private String current;
    private int idEncomenda;
    private LocalDateTime tempoChegada;
    private boolean recebido;

    
    //construtor Movimento
    public Movimento(String from, String to, String current, int id, LocalDateTime tempo) {
        this.from = from;
        this.to = to;
        this.current = current;
        this.idEncomenda = id;
        this.tempoChegada = tempo;
        this.recebido = false;
    }

    //get fornecedor da encomenda
    public String getFrom() {
        return from;
    }

    //set fornecedor da encomenda
    public void setFrom(String from) {
        this.from = from;
    }

    //get cliente da encomenda
    public String getTo() {
        return to;
    }

    //set cliente da encomenda
    public void setTo(String to) {
        this.to = to;
    }

    //get localizacao atual
    public String getCurrent() {
        return current;
    }

    //set localizacao atual
    public void setCurrent(String current) {
        this.current = current;
    }

    //get id da encomenda
    public int getIdEncomenda() {
        return idEncomenda;
    }

    //set id da encomenda
    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    //get tempo de chegada esperado
    public LocalDateTime getTempoChegada() {
        return tempoChegada;
    }

    //set tempo de chegada esperado
    public void setTempoChegada(LocalDateTime tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    //verificar se a encomenda ja chegou ao cliente
    public boolean isRecebido() {
        return recebido;
    }

    //set chegada da encomenda ao cliente 
    public void setRecebido(boolean recebido) {
        this.recebido = recebido;
    }

    @Override
    public String toString() {
        if (recebido == true) {
            return "Encomenda n. " + idEncomenda + " feita por " + to + " ao fornecedor " + from + ": " + current + " Recebida";
        } else {
            return "Encomenda n. " + idEncomenda + " feita por " + to + " ao fornecedor " + from + ": " + current;
        }
    }
}
