/**
 * Classe che rappresenta un prodotto da "passare" sulla cassa, è
 * caratterizzato da un nome e da un Importo che rappresenta il suo
 * prezzo. Inoltre implementa Comparable&lt;Prodotto&gt; in modo che i
 * prodotti siano ordinati in base al prezzo.
 *
 * @see java.lang.Comparable
 */
public class Prodotto implements Comparable<Prodotto> {
	private String nome;
	private Importo imp;

	/**
	 * Costruisce un prodotto con nome e prezzo in centesimi specificati.
	 * Solleva un'eccezione se il nome è null oppure se il prezzo è negativo.
	 *
	 * @param  nome  Nome del prodotto
	 * @param  val   Valore in centesimi
	 * @throws IllegalArgumentException  Se il nome è null o il valore è
	 *                                   negativo
	 */
	public Prodotto(String nome, int val) {
		if (nome == null  || val < 0)
			throw new IllegalArgumentException("Protoddo non valido!");

		this.nome = nome;
		this.imp = new Importo(val);
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

	/**
	 * Compara questa istanza di Prodotto con un'altra fornita come argomento.
	 *
	 * @param  prodotto  Prodotto da comparare
	 * @return           Restituisce un numero negativo, zero o uno positivo se
	 *                   il prezzo di questa istanza di prodotto è minore,
	 *                   uguale o maggiore di quello fornito come argomento.
	 */
	@Override
	public int compareTo(Prodotto prodotto) {
		return this.getPrezzo().compareTo(prodotto.getPrezzo());
	}
}
