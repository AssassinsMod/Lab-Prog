/**
 * Classe che rappresenta un prodotto da "passare" sulla cassa, è
 * caratterizzato da un nome e da un Importo che rappresenta il suo
 * prezzo. Inoltre implementa Comparable<Prodotto> in modo che i
 * prodotti siano ordinati in base al prezzo.
 */
public class Prodotto implements Comparable<Prodotto> {
	private String nome;
	private Importo imp;

	/**
	 * Costruisce un prodotto con nome e prezzo in centesimi specificati.
	 * Solleva un'eccezione se il nome è null oppure se il prezzo è negativo.
	 *
	 * @param  nome       Nome del prodotto
	 * @param  valInCent  Valore in centesimi
	 * @throws IllegalArgumentException  Se il nome è null o il valore è negativo
	 */
	public Prodotto(String nome, int valInCent) {
		if (nome == null  || valInCent < 0)
			throw new IllegalArgumentException("Protoddo non valido!");

		this.nome = nome;
		this.imp = new Importo(valInCent);
	}

	/**
	 * Restituisce il prezzo del prodotto
	 *
	 * @return  Importo del prodotto.
	 */
	public Importo getPrezzo() {
		return this.imp;
	}

	/**
	 * Restituisce il prezzo del prodotto, in centesimi.
	 *
	 * @return  Prezzo del prodotto in centesimi.
	 */
	public int prezzoInCentesimi() {
		return getPrezzo().inCentesimi();
	}

	/**
	 * Fornisce una descrizione testuale del prodotto.
	 *
	 * @return  Una stringa rappresentante l'istanza.
	 */
	public String toString() {
		return this.nome + " (€ " + prezzoInCentesimi() + ")";
	}

	@Override
	public int compareTo(Prodotto p) {
		return this.getPrezzo().compareTo(p.getPrezzo());
	}
}
