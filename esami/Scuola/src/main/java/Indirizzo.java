public class Indirizzo {
	private String localita, via;
	private int numero, cap;

	public Indirizzo(String loc, String via, int num, int cap) {
		if (cap < 0 || Integer.toString(cap).length() != 5)
			throw new IllegalArgumentException("CAP non valido!");

		this.localita = loc.toLowerCase();
		this.via = via.toLowerCase();
		this.numero = num;
		this.cap = cap;
	}

	public int getCap() {
		return this.cap;
	}

	public int getCivico() {
		return this.numero;
	}

	public String getLocalita() {
		return this.localita;
	}

	public String getVia_piazza() {
		return this.via;
	}

	@Override
	public String toString() {
		return getVia_piazza() + " " + getCivico() + ", " + getCap() +
		 " " + getLocalita();
	}
}
