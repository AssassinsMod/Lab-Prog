import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_PagaFallisce {
	@Test
	public void pagamentoErrato() {
		Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova",56));
		cassa.passa(new Prodotto("prova2",57));
		cassa.paga(new Banconota(5));
		cassa.passa(new Prodotto("prova3",23356));

		assertFalse(
			"Pagamento non sufficiente!",
			cassa.pagato()
		);
	}
}
