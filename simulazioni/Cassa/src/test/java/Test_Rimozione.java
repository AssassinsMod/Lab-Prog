import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_Rimozione {
	@Test
	public void rimozione() {
		Cassa cassa = new Cassa();
		Prodotto prod = new Prodotto("darimuovere", 678);

		cassa.passa(new Prodotto("prova",56));
		cassa.passa(new Prodotto("prova2",57));
		cassa.passa(prod);
		int temp = cassa.quanti();

		cassa.storna(1);
		cassa.storna(prod);

		assertEquals(
			"Contenuto della cassa non diminuito",
			2,
			temp - cassa.quanti()
		);
	}
}
