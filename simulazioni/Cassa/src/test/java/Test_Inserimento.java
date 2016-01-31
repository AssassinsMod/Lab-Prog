import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_Inserimento {
	@Test
	public void inserimento() {
        Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova", 56));
		int temp = cassa.quanti();

		cassa.passa(new Prodotto("prova", 57));

		assertEquals(
			"Contenuto non aumentato!",
			1,
			cassa.quanti() - temp
		);
	}
}
