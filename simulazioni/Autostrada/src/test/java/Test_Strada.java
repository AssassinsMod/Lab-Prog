import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_Strada {
    // Strada (50km, 100km/h)
    Strada s = new Strada(50, 100);

    @Test
    public void orePercorrenza() {
        assertThat("Le ore di percorrenza minime dovrebbero essere 0.5",
            s.orePercorrenzaVelocitaCodice(), is(0.5F));
    }

    @Test
    public void velocitaMedia() {
        assertThat("La velocità media dato 'T = 1800' dovrebbe essere 100",
            s.velocitaMediaDatoTempoPercorrenzaInSec(1800), is(100F));
    }

    @Test
    public void limiteSuperato() {
        assertThat("Con 'T = 1700' il limite dovrebbe essere stato superato",
            s.superatoLimiteDatoTempoPercorrenzaInSec(1700), is(true));
    }
}
