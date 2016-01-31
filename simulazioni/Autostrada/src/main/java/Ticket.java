public class Ticket{
	private Veicolo veicolo;
	private    long timestamp;

    /**
     * Crea una nuova istanza della classe Ticket dato un certo veicolo.
     *
     * @param  veicolo  veicolo associato al ticket
     */
    public Ticket(Veicolo veicolo) {
        this.veicolo = veicolo;
        this.timestamp = System.currentTimeMillis();
        veicolo.setTicket(this);
    }

    /**
     * Restituisce l'orario di ingresso.
     *
     * @return  timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Restituisce una stringa rappresentante lo stato attuale dell'istanza
     * di classe.
     *
     * @return  stato della classe
     */
    public String toString() {
        return "(T:" + getTimestamp() + ")";
    }
}
