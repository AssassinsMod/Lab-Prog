import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;

public class Test_FromFile {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void fileInesistente() throws FileNotFoundException {
		thrown.expect(FileNotFoundException.class);
		new Cassa().salvatempo("nonesiste");
	}

	@Test
	public void fileEsistente() {
		try {
			// jUnit (export prodotti.csv)
			File tmp = folder.newFile("prodotti.csv");
			BufferedWriter w = new BufferedWriter(new FileWriter(tmp));
			BufferedReader r = new BufferedReader(new InputStreamReader(
				this.getClass().getResourceAsStream("prodotti.csv")));
			String line;
			while ((line = r.readLine()) != null)
				w.write(line + "\n");
			w.close();
			r.close();
			// End

			Cassa cassa = new Cassa();

			cassa.salvatempo(tmp.getAbsolutePath());
			//cassa.salvatempo(
			//	getClass().getResourceAsStream("prodotti.csv"));

			assertThat("File non letto?",
				cassa.totaleInCentesimi() > 0, is(true));
		} catch (Exception e) {
			fail("Dovrebbe leggere 'prodotti.csv'!");
		}
	}
}
