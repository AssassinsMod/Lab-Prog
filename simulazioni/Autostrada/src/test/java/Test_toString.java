import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test_toString {
    private static String getClassRef(Object o) {
        return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
    }

    @Test
    public void Strada() {
        Strada s = new Strada(50, 50);

        assertThat("Strada is missing #toString() method",
            s.toString(), is(not(getClassRef(s))));
    }

    @Test
    public void StradaPedaggio() {
        StradaPedaggio sp = new StradaPedaggio(50, 50, 50);

        assertThat("StradaPedaggio is missing #toString() method",
            sp.toString(), is(not(getClassRef(sp))));
    }

    @Test
    public void Autostrada() {
        Autostrada a = new Autostrada(50, 50, 50, 50);

        assertThat("Autostrada is missing #toString() method",
            a.toString(), is(not(getClassRef(a))));
    }

    @Test
    public void Auto() {
        Auto auto = new Auto("MI***", 50);

        assertThat("Auto is missing #toString() method",
            auto.toString(), is(not(getClassRef(auto))));
    }

    @Test
    public void Tir() {
        Tir  tir  = new Tir("MI***", 500);

        assertThat("Tir is missing #toString() method",
            tir.toString(), is(not(getClassRef(tir))));
    }

    @Test
    public void Ticket() {
        Ticket t = new Ticket(new Auto("MI***", 50));

        assertThat("Ticket is missing #toString() method",
            t.toString(), is(not(getClassRef(t))));
    }
}
