import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_StradaPedaggio {
    // StradaPedaggio (50km, 100km/h, 0.2€/km)
    StradaPedaggio s = new StradaPedaggio(50, 100, 0.2F);


    @Test
    public void Auto() {
        Auto a = new Auto("MI***", 90);

        assertEquals(
        //  Il pedaggio per l'auto dovrebbe essere '10'
            10F,
            s.pedaggio(a),
            0F
        );
    }

    @Test
    public void Tir() {
        Tir  t = new Tir("MI***", 500);

        assertEquals(
        //  Il pedaggio per il tir dovrebbe essere '15'
            15F,
            s.pedaggio(t),
            0F
        );
    }
}
