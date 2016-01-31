public abstract class Veicolo {
    private String targa;
    private    int assi;
    private  float potenza;
    private Ticket ticket = null;

    /**
     * Crea una nuova istanza della classe Veicolo dati targa, assi e potenza.
     *
     * @param  targa    targa del veicolo
     * @param  assi     numero di assi
     * @param  potenza  potenza del veicolo (in kW)
     */
    public Veicolo(String targa, int assi, float potenza) {
        this.targa   = targa;
        this.assi    = assi;
        this.potenza = potenza;
    }

    /**
     * Restituisce la targa del veicolo.
     *
     * @return  targa
     */
    public String getTarga() {
        return targa;
    }

    /**
     * Restituisce il numero di assi del veicolo.
     *
     * @return  assi
     */
    public int getAssi() {
        return assi;
    }

    /**
     * Restituisce la potenza del veicolo.
     *
     * @return  potenza
     */
    public float getPotenza() {
        return potenza;
    }

    /**
     * Imposta il ticket del veicolo.
     *
     * @param  ticket  ticket del veicolo
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * Restituisce il ticket del veicolo.
     *
     * @return  ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Restituisce una stringa rappresentante lo stato attuale dell'istanza
     * di classe.
     *
     * @return  stato della classe
     */
    public String toString() {
        return "(T:" + getTarga() +
              ", A:" + getAssi() +
              ", P:" + getPotenza() +
              (getTicket() == null ? "" : "TICKET:" + getTicket().toString()) +
              ")";
    }
}
