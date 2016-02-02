import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_toString {
	@Test
	public void String() {
		Object o;

		assertThat("Banconota#toString",
			checkToString(new Banconota(5)), is(false));

		assertThat("Cassa#toString",
			checkToString(new Cassa()), is(false));

		assertThat("Importo#toString",
			checkToString(new Importo(545)), is(false));

		assertThat("Moneta#toString",
			checkToString(new Moneta(5)), is(false));

		assertThat("Prodotto#toString",
			checkToString(new Prodotto("prova", 5)), is(false));
	}

	private boolean checkToString(Object o) {
		return o.toString().equals(
			o.getClass().getName() + '@' + Integer.toHexString(o.hashCode()));
	}
}
