import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_Inserimento {
	@Test
	public void inserimento() {
        Cassa cassa = new Cassa();

		cassa.passa(new Prodotto("prova", 56));
		int temp = cassa.quanti();

		cassa.passa(new Prodotto("prova", 57));

		assertThat("Contenuto non aumentato!",
			cassa.quanti() - temp, is(1));
	}
}
