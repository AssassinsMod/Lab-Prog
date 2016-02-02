import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_Resto {
	@Test
	public void resto() {
		Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova",56));
		cassa.passa(new Prodotto("prova2",57));

		cassa.paga(new Moneta(100));
		cassa.paga(new Moneta(10));
		cassa.paga(new Moneta(10));

		assertThat("Errore nel resto del calcolo",
			cassa.calcolaResto().inCentesimi(), is(7));
	}
}
