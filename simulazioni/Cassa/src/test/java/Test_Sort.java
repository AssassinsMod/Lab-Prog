import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_Sort {
	@Test
	public void pagamentoErrato() {
		Cassa cassa = new Cassa();
		Prodotto prod;

		cassa.passa(new Prodotto("prova",56));
		cassa.passa(prod = new Prodotto("prova2", 357));
		cassa.passa(new Prodotto("prova3", 157));
		cassa.passa(new Prodotto("prova4", 57));

		assertEquals(
			"Più costoso",
			prod,
			cassa.piuCostoso()
		);
	}
}
