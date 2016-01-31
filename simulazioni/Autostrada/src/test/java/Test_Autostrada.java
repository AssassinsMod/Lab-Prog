import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_Autostrada {
	// Autostrada (50km, 100km/h, 0.2€/km, 50kW)
	Autostrada au = new Autostrada(50, 100, 0.2F, 50);
	Auto a = new Auto("MI***", 45);
	Tir  t = new Tir("MI***", 500);

	@Test
	public void ingresso() {
		boolean autoPassata = true;
		try {
			au.pedaggio(a);
		} catch (RuntimeException e) {
			autoPassata = false;
		}

		assertEquals(
			"L'auto non dovrebbe essere ammessa",
			false,
			autoPassata
		);
	}

	@Test
	public void pedaggio() {
		assertEquals(
		//  Il pedaggio per il tir dovrebbe essere '15'
			15F,
			au.pedaggio(t),
			0F
		);
	}
}
