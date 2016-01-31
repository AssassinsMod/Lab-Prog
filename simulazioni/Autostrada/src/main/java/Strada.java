public class Strada {
    private int lunghezza, limite;

    /**
     * Crea una nuova istanza della classe Strada dati limite di
     * velocità e lunghezza.
     *
     * @param  limite     limite di velocità
     * @param  lunghezza  lunghezza della strada
     */
    public Strada(int lunghezza, int limite) {
        this.lunghezza = lunghezza;
        this.limite = limite;
    }

    /**
     * Restituisce il limite della strada.
     *
     * @return  limite della strada
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Restituisce la lunghezza della strada
     *
     * @return  lunghezza della strada
     */
    public int getLunghezza() {
        return lunghezza;
    }

    /**
     * Ore necessarie per percorrere tutta la lunghezza della strada
     * alla velocità massima consentita.
     *
     * @return Tempo minimo
     */
    public float orePercorrenzaVelocitaCodice() {
        return ((float) getLunghezza()) / getLimite();
    }

    /**
     * Restituisce la velocità media tenuta dato un tempo di percorrenza
     * effettivo in secondi.
     *
     * @param  percorrenza  tempo effettivo in secondi
     * @return              velocità media
     */
    public float velocitaMediaDatoTempoPercorrenzaInSec(float percorrenza) {
        return getLunghezza() / (percorrenza / 3600);
    }

    /**
     * Restituisce true se dato il tempo di percorrenza in secondi si
     * può supporre che il limite di velocità sia stato superato.
     *
     * @param  percorrenza  tempo effettivo in secondi
     * @return              è stato superato il limite?
     */
    public boolean superatoLimiteDatoTempoPercorrenzaInSec(float percorrenza) {
        return velocitaMediaDatoTempoPercorrenzaInSec(percorrenza) > getLimite();
    }

    /**
     * Restituisce una stringa rappresentante lo stato attuale dell'istanza
     * di classe.
     *
     * @return  stato della classe
     */
    public String toString() {
        return "(" + getLimite() + ", " + getLunghezza() + ")";
    }
}
