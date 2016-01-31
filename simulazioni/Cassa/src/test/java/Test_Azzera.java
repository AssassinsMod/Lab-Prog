import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Test_Azzera {
    @Test
    public void azzeramento() {
        Cassa cassa = new Cassa();

        Prodotto p;
        try {
            cassa.passa(p = new Prodotto("prova", 56));
            cassa.passa(new Prodotto("prova2", 57));
            System.out.println(p);
        } catch (RuntimeException e) {
            fail("Errori durante l'aggiunta dei prodotti!");
        }

        try {
            cassa.paga(new Moneta(100));
            cassa.paga(new Moneta(10));
            cassa.paga(new Moneta(10));
        } catch (RuntimeException e) {
            fail("Errori durante il pagamento!");
        }

        assertEquals(
            "Azzeramento mal calcolato!",
            120,
            cassa.azzeramento().inCentesimi()
        );

        assertEquals(
            "Resto non azzerato!",
            0,
            cassa.quanti()
        );
    }
}
