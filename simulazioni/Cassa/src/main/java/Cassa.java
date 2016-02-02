import java.io.*;
import java.util.*;

/**
 * Rappresenta la cassa del supermercato, permette la scansione del Prodotto
 * (<i>"passaggio"</i>) e la rimozione (<i>"storno"</i>). Fornisce informazioni
 * sul contenuto. Accetta pagamento parziale e sa dire se il pagamento copre la
 * spesa.
 */
public class Cassa {
	private List<Prodotto> carrello;
	private int pagato;

	/**
	 * Costruttore senza argomenti, costruisce una cassa vuota.
	 */
	public Cassa() {
		this.carrello = new ArrayList<Prodotto>();
		this.pagato = 0;
	}

	/**
	 * Scansione del prodotto, viene aggiunto alla lista e concorre alla
	 * formazione del totale da pagare.
	 *
	 * @param  prodotto  Prodotto da aggiungere.
	 */
	public void passa(Prodotto prodotto) {
		carrello.add(prodotto);
	}

	/**
	 * Accetta pagamenti parziali, verranno passate istanze di Banconota e
	 * Moneta. Questo metodo verrà invocato più vlte fino al raggiungimento/
	 * superamento del totale da pagare.
	 *
	 * @param  denaro  Banconota o Moneta rappresentante il valore pagato.
	 */
	public void paga(Denaro denaro) {
		this.pagato += denaro.getValoreInCentesimi();
	}

	/**
	 * Fornisce lo stato del pagamento parziale, in centesimi.
	 *
	 * @return  Importo pagato in centesimi.
	 */
	public int getPagamentoParzialeInCentesimi() {
		return this.pagato;
	}

	/**
	 * Restituisce true se il denaro immesso finora copre la spesa totale.
	 *
	 * @return  true se si è coperta la spesa
	 */
	public boolean pagato() {
		return getPagamentoParzialeInCentesimi() >= totaleInCentesimi();
	}

	/**
	 * Azzera lo stato della cassa e segnala l'importo eventualmente pagato.
	 *
	 * @return  Importo pagato finora.
	 */
	public Importo azzeramento() {
		Importo pagato = new Importo(getPagamentoParzialeInCentesimi());

		this.pagato = 0;
		this.carrello.clear();

		return pagato;
	}

	/**
	 * Storna l'i-esimo prodotto dalla cassa, lo rimuove.
	 *
	 * @param  i  Indice del prodotto da rimuovere.
	 * @return    Prodotto rimosso.
	 * @throws  IndexOutOfBoundsException  Quando l'elemento non è presente.
	 */
	public Prodotto storna(int i) throws IndexOutOfBoundsException {
		return carrello.remove(i);
	}

	/**
	 * Storna il prodotto p dalla cassa, se c'è, lo rimuove sostituendolo al
	 * chiamante.
	 *
	 * @param  prodotto  Prodotto da rimuovere.
	 * @return    Prodotto rimosso.
	 * @throws IndexOutOfBoundsException quando l'elemento non è presente
	 */
	public Prodotto storna(Prodotto prodotto) throws IndexOutOfBoundsException {
		if (carrello.remove(prodotto))
			return prodotto;
		else
			throw new IndexOutOfBoundsException("Prodotto non trovato");
	}

	/**
	 * Calcola il resto, se c'è, zero altrimenti.
	 *
	 * @return  Resto dovuto.
	 */
	public Importo calcolaResto() {
		return new Importo(
			getPagamentoParzialeInCentesimi() - totaleInCentesimi());
	}

	/**
	 * Restituisce il numero di prodotti "passati".
	 *
	 * @return  Numero di elementi nel carrello.
	 */
	public int quanti() {
		return carrello.size();
	}

	/**
	 * Fornisce l'importo totale da pagare.
	 *
	 * @return  Importo da pagare
	 */
	public Importo totale() {
		return new Importo(totaleInCentesimi());
	}

	/**
	 * Fornisce il totale da pagare, in centesimi.
	 *
	 * @return  Totale da pagare, in centesimi.
	 */
	public int totaleInCentesimi() {
		int valoreCarrello = 0;

		for (Prodotto p : carrello)
			valoreCarrello += p.prezzoInCentesimi();

		return valoreCarrello;
	}

	/**
	 * Fornisce il prodotto piu costoso passato finora.
	 *
	 * @return  Prodotto più costoso.
	 */
	public Prodotto piuCostoso() {
		List<Prodotto> temp = new ArrayList<Prodotto>();

		for (Prodotto p : carrello)
			temp.add(p);

		Collections.sort(temp);

		return temp.get(temp.size() - 1);
	}

	/**
	 * Apre il file e legge i prodotti da passare nel formato 'nome,prezzo'.
	 *
	 * @param  file  Path relativa del file da leggere.
	 * @throws  FileNotFoundException   Se il file è inesistente.
	 * @throws  NoSuchElementException  Se il formato del file è errato.
	 * @throws  IllegalStateException   Se il lettore è stato chiuso.
	 */
	public void salvatempo(String file) throws FileNotFoundException, NoSuchElementException, IllegalStateException {

		Scanner reader = new Scanner(new File(file));

		String line;
		while(reader.hasNextLine() && !(line = reader.nextLine()).isEmpty()) {
			if (line.indexOf(',') == -1)
				throw new NoSuchElementException("Formato file non valido!");

			String[] d = line.split(",");
			carrello.add(new Prodotto(d[0], Integer.parseInt(d[1])));
		}
	}

	/**
	 * Fornisce una descrizione testuale della cassa.
	 *
	 * @return  Una stringa rappresentante l'istanza.
	 */
	public String toString() {
		return "Cassa<€ " + totaleInCentesimi() / 100 + "," +
			totaleInCentesimi() % 100 + " - " + quanti() + ">";
	}
}
