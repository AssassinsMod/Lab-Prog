import java.time.LocalDate;

public class Alunno implements Comparable<Alunno> {
	private String nome, cognome;
	private Indirizzo residenza;
	private LocalDate nascita;

	public Alunno(String nome, String cognome, Indirizzo residenza, LocalDate nascita) {
		this.nome = nome.toLowerCase();
		this.cognome = cognome.toLowerCase();
		this.residenza = residenza;
		this.nascita = nascita;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public LocalDate getNascita() {
		return this.nascita;
	}

	public Indirizzo getResidenza() {
		return this.residenza;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Alunno)) return false;

		Alunno a = (Alunno) o;
		return getCognome().equals(a.getCognome()) &&
			getNome().equals(a.getNome()) &&
			getNascita().equals(a.getNascita()) &&
			getResidenza().equals(a.getResidenza());
	}

	@Override
	public int compareTo(Alunno a) {
		String res;
		if (!(res = getCognome()).equals(a.getCognome()))
			return res.compareTo(a.getCognome());

		if (!(res = getNome()).equals(a.getNome()))
			return res.compareTo(a.getNome());

		return getNascita().compareTo(a.getNascita());
	}

	@Override
	public String toString() {
		return getCognome() + ", " + getNome();
	}
}
