package mariopizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mariopizza.Menukort.makePizza;

public class Statistik {
    //path til vores csv-fil der holder på bestillinger
    private static String filename = "Data/Bestillinger.csv";
    //oprettelse af arraylists, til statistik, bestillinger og kunder
    private static ArrayList<Bestilling> bestillingerStat = new ArrayList();
    private static ArrayList<Bestilling> bestillinger = new ArrayList();
    private static ArrayList<Kunde> kunder = new ArrayList();
    // metode der tilføjer kunde til vores kunder-arraylist
    public void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }
    //metode der checker om en given kundes telefonnummer allerede eksistere under 
    //andet navn, og retunere nyt navn til samme nummer
    public static Kunde checkKunde(int tlfnr) {
        for (Kunde kunde : kunder) {
            if (kunde.getNummer() == tlfnr) {
                return kunde;
            }
        }
        return null;
    }
    //Fjerner og tilføjer bestillinger
    public static void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public static void removeBestilling(Bestilling bestilling) {
        bestillinger.remove(bestilling);
    }
    //printer bestillinger
    public static void printBestilling() {
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling.getTid() + " , " + bestilling.printBes() + " " + bestilling.getKunde().getNavn());
        }
    }
    //fjerner/tilføjer bestillinger til statistik
    public static void addBestillingStat(Bestilling bestilling) {
        bestillingerStat.add(bestilling);
    }

    public static void printBestillingStat() {
        for (Bestilling bestillingStat : bestillingerStat) {
            System.out.println(bestillingStat.getTid() + " , " + bestillingStat.printBes() + " " + bestillingStat.getKunde().getNavn());

        }
    }
    //sortere vores bestillinger efter tid vha. vores compareTo metode i Bestilling.java
    public static void bestillingerEfterTid() {
        Collections.sort(bestillinger);
    }

    //Vi checker at det er den rigtige pizza vha. dens id, fordi vi ikke
    //kan oprette objekter at referere til
    public static Bestilling bestillingChecker(int id) {
        for (Bestilling bes : bestillinger) {
            if (bes.getId() == id) {
                return bes;
            }
        }
        return null;
    }

    //Metoden går ind og printer alle de pizzaer der er tilføjet til
    //bestillinger i statistikken
    public static void printAntalKøbtePizzaer() {
        int[] antalPizzaer = new int[Menukort.getAllePizzaer().size()];
        for (Bestilling bestilling : bestillingerStat) {
            for (Pizza piz : bestilling.getPizza()) {
                antalPizzaer[piz.getNummer() - 1]++;
            }
        }
        for (int i = 0; i < antalPizzaer.length; i++) {
            System.out.println(antalPizzaer[i]);
        }
    }

    //Metode der hjælper med at gemme pizzaer i vores csv fil efter der bliver
    //ændret i den
    public static void gemBestillingerCsv() {
        File file = new File(filename);
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            for (Bestilling bes : bestillinger) {
                fw.write(bes.getTid() + ";");
                fw.write(bes.getKunde().getNavn() + ";");
                fw.write(bes.getKunde().getNummer() + ";");

                for (Pizza piz : bes.getPizza()) {
                    fw.write(piz.getNummer() + ";");
                }
                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Menukort.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Metode der loader statistikken
    public static void StatLoad() {
        File file = new File(filename);
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] bes = line.split(";");
                String tid = bes[0];
                int nummer = Integer.parseInt(bes[2]);

                String pizzaer = "";
                for (int i = 3; i < bes.length; i++) {
                    pizzaer += bes[i] + ",";
                }
                Controller.tilføjBestilling(tid, pizzaer, bes[1], nummer);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
