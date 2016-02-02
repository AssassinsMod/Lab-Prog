import java.util.*;

public abstract class Scuola {
	private List<Classe> classi;
	private String denominazione;
	private Indirizzo localita;
	private int durata, maxAlunni;

	public Scuola(String den, Indirizzo loc, int max, int durata) {
		if (max < 2 || max > 30 || durata < 3 || durata > 5)
			throw new IllegalArgumentException(
				"Durata o numero massimo di studenti non valido");

		this.denominazione = den;
		this.localita = loc;
		this.maxAlunni = max;
		this.durata = durata;
		this.classi = new ArrayList<Classe>();
	}

	public int aulunnixClasse() {
		return this.maxAlunni;
	}

	public List<Classe> classi() {
		return this.classi;
	}

	public int getAnni() {
		return this.durata;
	}

	public Indirizzo getIndirizzo() {
		return this.localita;
	}

	public String getNome() {
		return this.denominazione;
	}

	public void aggiorna() {
		List<Classe> daRimuovere = new ArrayList<Classe>();

		for (Classe c : this.classi) {
			if (c.getAnno() == getAnni())
				daRimuovere.add(c);
			else
				c.aggiorna();
		}

		this.classi.removeAll(daRimuovere);
	}

	public boolean aggiungi(Alunno a, int anno, char sezione) {
		Classe c = classe(anno, sezione);

		if (c != null && c.quanti() < aulunnixClasse())
			return c.aggiungi(a);

		return false;
	}

	public Classe classe(Alunno a) {
		for (Classe c : classi)
			if (c.getAlunni().contains(a))
				return c;

		return null;
	}

	public Classe classe(int anno, char sezione) {
		sezione = Character.toLowerCase(sezione);

		for (Classe c : classi)
			if (c.getAnno() == anno && c.getSezione() == sezione)
				return c;

		return null;
	}

	public boolean creaClasse(Alunno[] alunni, int anno, char sezione) {
		if (alunni.length < aulunnixClasse() && classe(anno, sezione) == null)
			return this.classi.add(new Classe(alunni, anno, sezione));

		return false;
	}

	public void ordina() {
		Collections.sort(this.classi);
	}

	public boolean togli(Alunno a) {
		Classe c = classe(a);

		if (c != null)
			return c.togli(a);
		else
			return false;
	}

	@Override
	public String toString() {
		return "--| " + getNome() + " |--\n" +
			"Durata: " + getAnni() + "\n" +
			"Numero classi: " + classi().size() + "\n" +
			"Indirizzo: " + getIndirizzo() + "\n";
	}
}
