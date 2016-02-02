import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_Autostrada {

	@Test
	public void ingresso() {
		// Autostrada (50km, 100km/h, 0.2€/km, 50kW)
		Autostrada au = new Autostrada(50, 100, 0.2F, 50);
		Auto a = new Auto("MI***", 45);

		boolean autoPassata = true;

		try {
			au.ingresso(a);
		} catch (RuntimeException e) {
			autoPassata = false;
		}

		assertThat("L'auto non dovrebbe essere ammessa",
			autoPassata, is(false));
	}

	@Test
	public void pedaggio() {
		// Autostrada (50km, 100km/h, 0.2€/km, 50kW)
		Autostrada au = new Autostrada(50, 100, 0.2F, 50);
		Tir  t = new Tir("MI***", 500);

		assertThat("Il pedaggio per il tir dovrebbe essere '15'",
			au.pedaggio(t), is(15F));
	}
}
