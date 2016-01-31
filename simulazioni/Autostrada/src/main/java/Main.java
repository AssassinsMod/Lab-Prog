import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Autostrada a = new Autostrada(50, 100, 0.2F, 50);
        List<Veicolo> veicoli = new ArrayList<Veicolo>();

        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(
                Main.class.getClassLoader().getResourceAsStream("autostrada.txt")));

            String line;
            while ((line = r.readLine()) != null && !line.isEmpty()) {
                String[] data = line.split(";");

                if (data[0].equals("Auto")) {
                    veicoli.add(new Auto(data[1], Float.parseFloat(data[2])));
                } else if (data[0].equals("Tir")) {
                    veicoli.add(new Tir(data[1], Float.parseFloat(data[2])));
                } else {
                    System.out.println("Tipo di veicolo non riconosciuto!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IO Exception occurred");
        }

        System.out.println("---| Ingresso Veicoli |---");
        for (Veicolo v : veicoli) {
            try { a.ingresso(v); }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println(v.toString() + "\t" + a.toString());
        }

        System.out.println("\nPotenza Media: " + a.potenzaMedia());

        System.out.println("---| Uscita Veicoli |---");
        for (Veicolo v : veicoli) {
            try { a.uscita(v); }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println(v.toString() + "\t" + a.toString());
        }
    }
}
