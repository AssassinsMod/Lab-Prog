/**
 * Rappresenta una cifra di denaro in euro e centesimi, ma non è costante.
 * Implementa Comparable<Importo>.
 */
public class Importo implements Comparable<Importo> {
	private int val;

	public Importo(int valInCent) {
		this.val = valInCent;
	}

	/**
	 * Restituisce il valore in centesimi.
	 *
	 * @return  Valore in centesimi.
	 */
	public int inCentesimi() {
		return this.val;
	}

	/**
	 * Fornisce una descrizione testuale dell'istanza.
	 *
	 * @return  Una stringa contenente lo stato dell'istanza
	 */
	public String toString() {
		return "€ " + (inCentesimi() / 100) + "," + (inCentesimi() % 100);
	}

	@Override
	public int compareTo(Importo i) {
		return inCentesimi() - i.inCentesimi();
	}
}
