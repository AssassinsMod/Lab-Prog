import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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

		assertThat("Contenuto della cassa non diminuito",
			temp - cassa.quanti(), is(2));
	}
}
