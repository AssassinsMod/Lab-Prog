import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_PagaInPiuStep {
	@Test
	public void pagamentoInPiuStep() {
		Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova",56));
		cassa.passa(new Prodotto("prova2",57));

		cassa.paga(new Moneta(100));
		cassa.paga(new Moneta(10));
		cassa.paga(new Moneta(10));

		assertTrue(
			"Errore nel calcolo del pagamento in più step",
			cassa.pagato()
		);
	}
}
