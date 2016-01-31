import java.util.*;

public class Autostrada extends StradaPedaggio {
    private float potenzaMinimaPerAccedere;
    private List<Veicolo> veicoli;

    /**
     * Crea una nuova istanza della classe Strada dati limite di
     * velocità, tariffa base per km e potenza minima.
     *
     * @param  limite       limite di velocità
     * @param  lunghezza    lunghezza della strada
     * @param  tariffaBase  tariffa in €/km
     * @param  potenzaMinimaPerAccedere  potenza richiesta per accedere
     */
    public Autostrada(int lunghezza, int limite, float tariffaBase,
                      float potenzaMinimaPerAccedere) {
        super(lunghezza, limite, tariffaBase);
        this.potenzaMinimaPerAccedere = potenzaMinimaPerAccedere;
        this.veicoli = new ArrayList<Veicolo>();
    }

    /**
     * Restituisce la potenza minima necessaria per accedere.
     *
     * @return  potenza minima in kW
     */
    public float getPotenzaMinimaPerAccedere() {
        return potenzaMinimaPerAccedere;
    }

    /**
     * Restituisce la lista di veicoli presenti nell'autostrada.
     *
     * @return  lista di veicoli
     */
    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    /**
     * Calcola il pedaggio in euro in funzione di: tariffa base, lunghezza e
     * numero di assi del veicolo. Restituisce un errore se il veicolo non
     * raggiunge la potenza minima per accedere all'autostrada.
     *
     * @param  v  veicolo
     * @return    importo da pagare
     * @throws RuntimeException  quando il veicolo non raggiunge la potenza
                                 minima richiesta
     */
    @Override
    public float pedaggio(Veicolo v) {
        if (v.getPotenza() < getPotenzaMinimaPerAccedere())
            throw new RuntimeException("Il veicolo non raggiunge la potenza minima richiesta");

        return super.pedaggio(v);
    }

    /**
     * Se il veicolo è ammesso rilascia un Ticket per il veicolo, altrimenti
     * lancia una eccezione.
     *
     * @param  v  veicolo che vuole essere immesso
     * @return    ticket se il veicolo è stato ammesso
     * @throws RuntimeException se il veicolo non raggiunge la potenza minima
     */
    public Ticket ingresso(Veicolo v) {
        if (v.getPotenza() < getPotenzaMinimaPerAccedere())
            throw new RuntimeException("Il veicolo non raggiunge la potenza minima richiesta");

        veicoli.add(v);
        return new Ticket(v);
    }

    /**
     * Se il veicolo non è presente tra quelli entrati lancia una eccezione.
     * Se il tempo è inferiore a quello minimo lancia una MultaException.
     * Altrimenti calcola il pedaggio e fa uscire il veicolo.
     *
     * @param  v  veicolo che vuole uscire
     * @return    pedaggio da pagare
     * @throws RuntimeException se il veicolo non è tra quelli ammessi
     * @throws MultaException se ha infranto il limite di velocità
     */
    public float uscita(Veicolo v) {
        if (!veicoli.contains(v))
            throw new RuntimeException("Il veicolo non risulta essere stato ammesso!");

        float percorrenza =
            (System.currentTimeMillis() - v.getTicket().getTimestamp()) / 1000F;
        if (superatoLimiteDatoTempoPercorrenzaInSec(percorrenza))
            throw new MultaException("Superato il limite di velocità massimo");

        veicoli.remove(v);
        return pedaggio(v);
    }

    /**
     * Restituisce il numero di veicoli attualmente presenti in autostrada.
     *
     * @return  numero di veicoli presenti
     */
    public int quantiVeicoli() {
        return veicoli.size();
    }

    /**
     * Restituisce la potenza media dei veicoli attualmente presenti in
     * autostrada.
     *
     * @return  potenza media
     */
    public float potenzaMedia() {
        float potenzaTotale = 0;
        for (Veicolo v : veicoli)
            potenzaTotale += v.getPotenza();
        return potenzaTotale / quantiVeicoli();
    }

    public String toString() {
        return super.toString() + "\b, " + getPotenzaMinimaPerAccedere() + ")";
    }
}
