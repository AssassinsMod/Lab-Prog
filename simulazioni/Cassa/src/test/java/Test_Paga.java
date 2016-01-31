import org.junit.Test;
import static org.junit.Assert.*;

public class Test_Paga {
	@Test
	public void pagamento() {
		Cassa cassa = new Cassa();
		
		cassa.passa(new Prodotto("prova", 56));
		cassa.passa(new Prodotto("prova2", 57));

		cassa.paga(new Banconota(5));

		assertTrue(
			"Non ha pagato?",
			cassa.pagato()
		);
	}
}
