import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_toString {
	@Test
	public void String() {
		Object o;

		assertFalse(
			"Banconota#toString",
			checkToString(new Banconota(5))
		);

		assertFalse(
			"Cassa#toString",
			checkToString(new Cassa())
		);

		assertFalse(
			"Importo#toString",
			checkToString(new Importo(545))
		);

		assertFalse(
			"Moneta#toString",
			checkToString(new Moneta(5))
		);

		assertFalse(
			"Prodotto#toString",
			checkToString(new Prodotto("prova", 5))
		);
	}

	private boolean checkToString(Object o) {
		return o.toString().equals(
			o.getClass().getName() + '@' + Integer.toHexString(o.hashCode()));
	}
}
