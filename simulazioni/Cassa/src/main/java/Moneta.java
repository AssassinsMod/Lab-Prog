import java.util.Arrays;

public class Moneta extends Denaro {
	public static int[] VALORI_VALIDI = {1, 2, 5, 10, 20, 50, 100, 200};

	public Moneta(int val) {
		if (Arrays.binarySearch(VALORI_VALIDI, val) < 0)
			throw new IllegalArgumentException("Valore non valido!");

		super.setValoreInCentesimi(val);
	}

	/* #toString() - viene ereditato da Denaro */
}
