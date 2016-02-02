import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_Paga {
	@Test
	public void pagamento() {
		Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova", 56));
		cassa.passa(new Prodotto("prova2", 57));

		cassa.paga(new Banconota(5));

		assertThat("Non ha pagato?", cassa.pagato(), is(true));
	}
}
