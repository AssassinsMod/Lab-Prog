import java.util.Arrays;

/**
 * Sottoclasse di Denaro che rappresenta monete cartacee.
 */
public class Banconota extends Denaro {
	/**
	 * Insieme di valori ammissibili nel costruttore di Banconota.
	 */
	public static final int[] VALORI_VALIDI = {5, 10, 20, 50, 100, 200, 500};

	/**
	 * Crea una nuova istanza di Banconota dato il valore in euro.
	 *
	 * @param  val  Valore in euro.
	 * @throws  IllegalArgumentException  Se il valore passato nel costruttore
	 *                                    non è valido.
	 */
	public Banconota(int val) {
		if (Arrays.binarySearch(VALORI_VALIDI, val) < 0)
			throw new IllegalArgumentException("Valore non valido!");

		super.setValoreInCentesimi(val * 100);
	}
}
