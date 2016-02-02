/**
 * Classe astratta che rappresenta del contante in centesimi.
 */
public abstract class Denaro {
	private int val;

	/**
	 * Restituisce il valore in centesimi.
	 *
	 * @return  Valore in centesimi.
	 */
	public int getValoreInCentesimi() {
		return this.val;
	}

	/**
	 * Modifica il valore in centesimi.
	 *
	 * @param  val  Valore in centesimi.
	 */
	public void setValoreInCentesimi(int val) {
		this.val = val;
	}

	/**
	 * Restituisce l'importo corrispondente al valore in centesimi.
	 *
	 * @return  Importo corrispondente al valore in centesimi.
	 */
	public Importo getImporto() {
		return new Importo(getValoreInCentesimi());
	}

	/**
	 * Fornisce una descrizione testuale dell'istanza.
	 *
	 * @return  Una stringa contenente lo stato dell'istanza
	 */
	public String toString() {
		return "€ " + (getValoreInCentesimi() / 100) + "," + (getValoreInCentesimi() % 100);
	}
}
