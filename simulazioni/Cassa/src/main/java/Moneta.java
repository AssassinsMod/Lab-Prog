import java.util.Arrays;

/**
 * Sottoclasse di Denaro che rappresenta monete metalliche.
 */
public class Moneta extends Denaro {
	/**
	 * Insieme di valori ammissibili nel costruttore di Moneta.
	 */
	public static final int[] VALORI_VALIDI = {1, 2, 5, 10, 20, 50, 100, 200};

	/**
	 * Crea una nuova istanza di Moneta dato il valore in euro.
	 *
	 * @param  val  Valore in euro.
	 * @throws  IllegalArgumentException  Se il valore passato nel costruttore
	 *                                    non è valido.
	 */
	public Moneta(int val) {
		if (Arrays.binarySearch(VALORI_VALIDI, val) < 0)
			throw new IllegalArgumentException("Valore non valido!");

		super.setValoreInCentesimi(val);
	}
}
