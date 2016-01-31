import java.util.Arrays;

public class Banconota extends Denaro {
	public static int[] VALORI_VALIDI = {5, 10, 20, 50, 100, 200, 500};

	public Banconota(int val) {
		if (Arrays.binarySearch(VALORI_VALIDI, val) < 0)
			throw new IllegalArgumentException("Valore non valido!");

		super.setValoreInCentesimi(val * 100);
	}

	/* #toString() - viene ereditato da Denaro */
}
