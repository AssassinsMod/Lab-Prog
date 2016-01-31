public class StradaPedaggio extends Strada {
    private float tariffaBase;

    /**
     * Crea una nuova istanza della classe StradaPedaggio dati limite di
     * velocità, lunghezza e tariffa base per kilometro.
     *
     * @param  limite       limite di velocità
     * @param  lunghezza    lunghezza della strada
     * @param  tariffaBase  tariffa in €/km
     */
    public StradaPedaggio(int lunghezza, int limite, float tariffaBase) {
        super(lunghezza, limite);
        this.tariffaBase = tariffaBase;
    }

    /**
     * Restituisce la tariffa base della strada.
     *
     * @return  tariffa in €/km
     */
    public float getTariffaBase() {
        return tariffaBase;
    }

    /**
     * Calcola il pedaggio in euro in funzione di: tariffa base, lunghezza e
     * numero di assi del veicolo.
     *
     * @param  v  veicolo
     * @return    importo da pagare
     */
    public float pedaggio(Veicolo v) {
        return getTariffaBase() * getLunghezza() * (v.getAssi() > 3 ? 1.5F : 1F);
    }

    public String toString() {
        return super.toString() + "\b, " + getTariffaBase() + ")";
    }
}
