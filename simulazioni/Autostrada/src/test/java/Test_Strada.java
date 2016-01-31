import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Test_Strada {
    // Strada (50km, 100km/h)
    Strada s = new Strada(50, 100);

    @Test
    public void orePercorrenza() {
        assertEquals(
        //  Le ore di percorrenza minime dovrebbero essere 0.5
            0.5F,
            s.orePercorrenzaVelocitaCodice(),
            0F
        );
    }

    @Test
    public void velocitaMedia() {
        assertEquals(
        //  La velocità media dato 'T = 1800' dovrebbe essere 100
            100F,
            s.velocitaMediaDatoTempoPercorrenzaInSec(1800),
            0F
        );
    }

    @Test
    public void limiteSuperato() {
        assertEquals(
            "Con 'T = 1700' il limite dovrebbe essere stato superato",
            true,
            s.superatoLimiteDatoTempoPercorrenzaInSec(1700)
        );
    }
}
