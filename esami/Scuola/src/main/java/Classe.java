import java.util.*;

public class Classe implements Comparable<Classe> {
	private List<Alunno> alunni;
	private int anno;
	private char sezione;

	public Classe(Alunno[] alunni, int anno, char sezione) {
		if (anno < 1 || anno > 5 || !Character.isAlphabetic(sezione))
			throw new IllegalArgumentException("Valori immessi non validi!");

		this.alunni = new ArrayList<Alunno>();
		for (Alunno a : alunni)
			this.alunni.add(a);

		this.anno = anno;
		this.sezione = Character.toLowerCase(sezione);
	}

	public List<Alunno> getAlunni() {
		return this.alunni;
	}

	public int getAnno() {
		return this.anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public char getSezione() {
		return this.sezione;
	}

	public void aggiorna() {
		if (getAnno() < 5)
			setAnno(this.anno + 1);
	}

	public boolean aggiungi(Alunno a) {
		return alunni.add(a);
	}

	public void ordina() {
		Collections.sort(this.alunni);
	}

	public int quanti() {
		return getAlunni().size();
	}

	public boolean togli(Alunno a) {
		return alunni.remove(a);
	}

	@Override
	public int compareTo(Classe c) {
		if (getAnno() != c.getAnno())
			return getAnno() - c.getAnno();

		return new Character(getSezione()).compareTo(
			new Character(c.getSezione()));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("--| Classe |--\n");
		sb.append("Sezione: " + getSezione() + "\n");
		sb.append("Anno: " + getAnno() + "\n");
		sb.append("Alunni: \n");
		for (Alunno a : alunni)
			sb.append(" - " + a.toString() + "\n");

		return sb.toString();
	}
}
