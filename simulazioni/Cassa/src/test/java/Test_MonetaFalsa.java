import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_MonetaFalsa {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void banconotaFalsa() {
		thrown.expect(RuntimeException.class);
		new Banconota(3);
	}

	@Test
	public void monetaFalsa() {
		thrown.expect(RuntimeException.class);
		new Moneta(3);
	}
}
