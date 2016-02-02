import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_StradaPedaggio {
    // StradaPedaggio (50km, 100km/h, 0.2€/km)
    StradaPedaggio s = new StradaPedaggio(50, 100, 0.2F);


    @Test
    public void Auto() {
        Auto a = new Auto("MI***", 90);

        assertThat("Il pedaggio per l'auto dovrebbe essere '10'",
            s.pedaggio(a), is(10F));
    }

    @Test
    public void Tir() {
        Tir  t = new Tir("MI***", 500);

        assertThat("Il pedaggio per il tir dovrebbe essere '15'",
            s.pedaggio(t), is(15F));
    }
}
