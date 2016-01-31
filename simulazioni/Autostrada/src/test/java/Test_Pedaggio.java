import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_Pedaggio {
    // Autostrada (50km, 100km/h, 0.2€/km, 50kW)
    Autostrada au = new Autostrada(50,100,.20f,50);
    Auto a1 = new Auto("MI...", 80);
    Auto a2 = new Auto("PV...", 90);
    Tir  t1 = new Tir("MI...", 500);
    Tir  t2 = new Tir("BO...", 600);

    @Test
    public void ingresso() {
        au.ingresso(a1);
        au.ingresso(a2);
        au.ingresso(t1);
        au.ingresso(t2);

        assertEquals(
            "Dovrebbero essere presenti 4 veicoli",
            4,
            au.quantiVeicoli()
        );
    }

    @Test
    public void potenzaMedia() {
        ingresso();

        assertEquals(
        //  La potenza media non corrisponde
            ((80 + 90 + 500 + 600) / 4F),
            au.potenzaMedia(),
            0F
        );
    }

    @Test
    public void uscita() {
        boolean autoUscita = true;
        try {
            au.uscita(new Auto("CO***", 90));
        } catch (RuntimeException e) {
            autoUscita = false;
        }
        assertEquals(
            "L'auto non esiste, dovrebbe dare errore!",
            false,
            autoUscita
        );
    }


    @Test
    public void Multa() {
        ingresso();

        boolean autoMultata = false;
        try {
            Thread.sleep(1000);
            au.uscita(a1);
        } catch (MultaException e) {
            autoMultata = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(
            "L'auto dovrebbe essere stata multata",
            true,
            autoMultata
        );
    }
}
