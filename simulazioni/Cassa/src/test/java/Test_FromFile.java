import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class Test_FromFile {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void fileInesistente() throws FileNotFoundException {
		thrown.expect(FileNotFoundException.class);
		new Cassa().salvatempo("nonesiste");
	}

	@Test
	public void fileEsistente() {
		try {
			Cassa cassa = new Cassa();

			cassa.salvatempo(
				getClass().getResourceAsStream("prodotti.csv"));

			assertTrue(
				"File non letto?",
				cassa.totaleInCentesimi() > 0
			);
		} catch (Exception e) {
			fail("Dovrebbe leggere 'prodotti.csv'!");
		}
	}
}
