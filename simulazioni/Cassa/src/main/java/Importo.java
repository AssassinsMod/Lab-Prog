/**
 * Rappresenta una cifra di denaro in euro e centesimi, ma non è costante.
 * Implementa Comparable&lt;Importo&gt;.
 * @see java.lang.Comparable
 */
public class Importo implements Comparable<Importo> {
	private int val;

	/**
	 * Crea una istanza di importo.
	 *
	 * @param  val  Valore in centesimi.
	 */
	public Importo(int val) {
		this.val = val;
	}

	/**
	 * Restituisce il valore in centesimi dell'istanza.
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

	/**
	 * Compara questa istanza di Importo con un'altra fornita come argomento.
	 *
	 * @param  importo  Importo da comparare
	 * @return          Restituisce un numero negativo, zero o uno positivo se
	 *                  questo importo è minore, uguale o maggiore di quello
	 *                  fornito come argomento.
	 */
	@Override
	public int compareTo(Importo importo) {
		return inCentesimi() - importo.inCentesimi();
	}
}
