import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class Test_toString {
    private static String getClassRef(Object o) {
        return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
    }

    @Test
    public void Strada() {
        Strada s = new Strada(50, 50);

        assertNotSame(
            "Strada is missing #toString() method",
            getClassRef(s),
            s.toString()
        );
    }

    @Test
    public void StradaPedaggio() {
        StradaPedaggio sp = new StradaPedaggio(50, 50, 50);

        assertNotSame(
            "StradaPedaggio is missing #toString() method",
            getClassRef(sp),
            sp.toString()
        );
    }

    @Test
    public void Autostrada() {
        Autostrada a = new Autostrada(50, 50, 50, 50);

        assertNotSame(
            "Autostrada is missing #toString() method",
            getClassRef(a),
            a.toString()
        );
    }

    @Test
    public void Auto() {
        Auto auto = new Auto("MI***", 50);

        assertNotSame(
            "Auto is missing #toString() method",
            getClassRef(auto),
            auto.toString()
        );
    }

    @Test
    public void Tir() {
        Tir  tir  = new Tir("MI***", 500);

        assertNotSame(
            "Tir is missing #toString() method",
            getClassRef(tir),
            tir.toString()
        );
    }

    @Test
    public void Ticket() {
        Ticket t = new Ticket(new Auto("MI***", 50));

        assertNotSame(
            "Ticket is missing #toString() method",
            getClassRef(t),
            t.toString()
        );
    }
}
