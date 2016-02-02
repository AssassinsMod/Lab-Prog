import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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

        assertThat("Dovrebbero essere presenti 4 veicoli",
            au.quantiVeicoli(), is(4));
    }

    @Test
    public void potenzaMedia() {
        ingresso();

        assertThat("La potenza media non corrisponde",
            au.potenzaMedia(), is((80 + 90 + 500 + 600) / 4F));
    }

    @Test
    public void uscita() {
        boolean autoUscita = true;
        try {
            au.uscita(new Auto("CO***", 90));
        } catch (RuntimeException e) {
            autoUscita = false;
        }
        assertThat("L'auto non esiste, dovrebbe dare errore!",
            autoUscita, is(false));
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
        assertThat("L'auto dovrebbe essere stata multata",
            autoMultata, is(true));
    }
}
