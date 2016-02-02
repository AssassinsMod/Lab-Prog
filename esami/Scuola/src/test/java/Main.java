import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void indirizzo() {
		Indirizzo i = null;

		try {
			i = new Indirizzo("Milano", "Via Comelico", 15, 20139);
		} catch (RuntimeException e) {
			fail("Errore durante l'inizializzazione della classe Indirizzo!");
		}

		assertThat("Località errata", i.getLocalita(), is("milano"));
		assertThat("Via errata", i.getVia_piazza(), is("via comelico"));
		assertThat("Civico errato", i.getCivico(), is(15));
		assertThat("Cap errato", i.getCap(), is(20139));
		assertThat("toString non implementato", i.toString(), allOf(
			containsString("milano"),
			containsString("via comelico")
		));
	}

	@Test
	public void indirizzoNonValido() {
		thrown.expect(RuntimeException.class);
		new Indirizzo("Milano", "via Mazzini", 1, 206159);
	}

	@Test
	public void alunno() {
		Alunno a1 = null,
		       a2 = null;

		LocalDate d1 = LocalDate.of(2012, 11, 14),
		          d2 = LocalDate.of(2012,  9,  8);

		Indirizzo i1 = new Indirizzo("Milano", "Via Comelico", 15, 20139),
		          i2 = new Indirizzo("Monza", "via Dante", 1, 20159);

		try {
			a1 = new Alunno("pinco", "pallino", i1, d1);
			a2 = new Alunno ("Pinco", "Pallino", i1, d1);
		} catch (RuntimeException e) {
			fail("Errore durante l'inizializzazione della classe Alunno!");
		}

		assertThat("Nome errato", a1.getNome(), is("pinco"));
		assertThat("Cognome errato", a1.getCognome(), is("pallino"));
		assertThat("Indirizzo errato", a1.getResidenza(), is(i1));
		assertThat("Data errata", a1.getNascita(), is(d1));

		assertThat("Equals deve restituire true", a2.equals(a1), is(true));
		assertThat("CompareTo deve restituire 0", a2.compareTo(a1), is(0));

		assertThat("toString errato o incompleto", a1.toString(), allOf(
			containsString("pinco"),
			containsString("pallino")
		));

		a2 = new Alunno("Pinco", "Palletto", i2, d2);

		assertThat("'Pinco Palletto' deve venire prima di 'Pinco Pallino'",
			a2.compareTo(a1) < 0, is(true));
	}

	@Test
	public void classe() {
		Indirizzo i1 = new Indirizzo("Milano", "Via Comelico", 15, 20139),
		          i2 = new Indirizzo("Monza", "via Dante", 1, 20159);

   		LocalDate d1 = LocalDate.of(2012, 11, 14),
   		          d2 = LocalDate.of(2012,  9,  8),
   		          d3 = LocalDate.of(2012,  2, 14);

		Alunno a1 = new Alunno("pinco", "pallino", i1, d1),
		       a2 = new Alunno("Pinco", "Palletto", i2, d2),
		       a3 = new Alunno("scevola", "muzio", i2, d3),
		       a4 = new Alunno("flaminio","massimo",i1,d1),
		       a5 = new Alunno("antonio","agrippa",i2,d1);

		Classe c1 = null,
		       c2 = null;

		Alunno[] alunni = new Alunno[] { a1, a3, a2 };

		try {
			c1 = new Classe(alunni, 1, 'A');
		} catch (RuntimeException e) {
			fail("Errore durante l'inizializzazione della classe Classe!");
		}

		assertThat("La classe deve avere '" + a3 + "'",
			c1.getAlunni(), allOf(hasItem(a1), hasItem(a2), hasItem(a3)));

		assertThat("La classe deve contenere 3 alunni", c1.quanti(), is(3));
		assertThat("L'anno della classe deve essere 1", c1.getAnno(), is(1));
		assertThat("La sezione della classe deve essere 'a'",
			c1.getSezione(), is('a'));

		c1.aggiorna();

		assertThat("L'anno deve essere aggiornato a 2", c1.getAnno(), is(2));

		c1.ordina();
		Arrays.sort(alunni);

		assertThat("La classe non è ordinata", c1.getAlunni(), is(Arrays.asList(alunni)));

		c1.togli(new Alunno("scevola", "muzio", i2, d3));

		assertThat("'Munzio Scevola' non dovrebbe essere presente", c1.getAlunni(), not(hasItem(a3)));
		assertThat("Gli alunni devono essere 2", c1.quanti(), is(2));

		c1.aggiungi(a3);

		assertThat("'Munzio Scevola' dovrebbe essere presente",
			c1.getAlunni(), hasItem(a3));
		assertThat("Gli alunni devono essere 3",
			c1.quanti(), is(3));

		c2 = new Classe(new Alunno[] { a4, a5 }, 1, 'B');

		assertThat("Ordine delle classi sbagliato!",
			c1.compareTo(c2) >= 0, is(true));
		assertThat("toString della classe errato o incompleto",
			c2.toString(), containsString("flaminio"));
	}

	@Test
	public void scuola() {
		Indirizzo i1 = new Indirizzo("Milano", "Via Comelico", 15, 20139),
		          i2 = new Indirizzo("Monza", "via Dante", 1, 20159);

   		LocalDate d1 = LocalDate.of(2012, 11, 14),
   		          d2 = LocalDate.of(2012,  9,  8),
   		          d3 = LocalDate.of(2012,  2, 14);

		Alunno a1 = new Alunno("pinco", "pallino", i1, d1),
		       a2 = new Alunno("Pinco", "Palletto", i2, d2),
		       a3 = new Alunno("scevola", "muzio", i2, d3),
		       a4 = new Alunno("flaminio", "massimo", i1, d1),
		       a5 = new Alunno("antonio", "agrippa", i2, d1),
		       a6 = new Alunno("lucrezia", "agrippa", i1, d3);

		Scuola s = null;

		try {
			s = new ScuolaMedia("media ideale", i1, 4);
		} catch (RuntimeException e) {
			fail("Errore durante l'inizializzazione della classe Scuola!");
		}

		assertThat("Numero massimo di alunni per classe errato", s.aulunnixClasse(), is(4));
		assertThat("Indirizzo errato", s.getIndirizzo(), is(i1));
		assertThat("Nome errato", s.getNome(), is("media ideale"));

		s.creaClasse(new Alunno[] { a1, a3, a2}, 1, 'a');
		s.creaClasse(new Alunno[] { a6 }, 3, 'a');
		s.creaClasse(new Alunno[] { a4, a5 }, 1, 'b');

		assertThat("Il numero di classi deve essere 3",
			s.classi().size(), is(3));
		assertThat("La classe 1A deve avere 3 alunni",
			s.classe(1, 'a').quanti(), is(3));
		assertThat("La classe 1D non deve esisrete",
			s.classe(1, 'd'), nullValue());

		Classe c = s.classe(a1);

		assertThat("La classe deve essere la 1A", c.getAnno(), is(1));
		assertThat("La classe deve essere la 1A", c.getSezione(), is('a'));

		s.ordina();
		c = s.classi().get(1);

		assertThat("Le classi non sono ordinate", c.getAnno(), is(1));
		assertThat("Le classi non sono ordinate", c.getSezione(), is('b'));

		s.togli(a4);

		assertThat("La classe 1B deve avere 1 studente",
			s.classe(1, 'b').quanti(), is(1));

		s.aggiungi(a4, 1, 'a');

		assertThat("La classe 1A deve avere 4 studenti",
			s.classe(1, 'a').quanti(), is(4));

		s.aggiungi(a1, 1, 'a');

		assertThat("Il numero di alunni nella 1A non dovrebbe variare",
			s.classe(1, 'a').quanti(), is(4));

		s.aggiorna();

		assertThat("La 2A dovrebbe esistere",
			s.classe(2, 'a'), notNullValue());
		assertThat("La 1A non dovrebbe esistere",
			s.classe(1, 'a'), nullValue());
		assertThat("Ci dovrebbero essere solo 2 classi",
			s.classi().size(), is(2));
	}
}
