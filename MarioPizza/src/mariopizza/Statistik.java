package mariopizza;

import java.util.ArrayList;

public class Statistik extends BestillingsListe{

    private static ArrayList<Bestilling> bestillinger = new ArrayList();
    private static ArrayList<Kunde> kunder = new ArrayList();

    public void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    public static Kunde checkKunde(int tlfnr) {
        for (Kunde kunde : kunder) {
            if (kunde.getNummer() == tlfnr) {
                return kunde;
            }
        }
        return null;
    }

    public static void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public static void removeBestilling(Bestilling bestilling) {
        bestillinger.remove(bestilling);
    }

    public static void printBestilling() {
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling.getTid() + " , " + bestilling.printBes() + " Kunde:" + bestilling.getKunde().getNavn() + "Telefon: " + bestilling.getKunde().getNummer());
        }
    }
    
    public static Bestilling bestillingChecker(int id) {
        for (Bestilling bes : bestillinger) {
            if (bes.getId() == id) {
                return bes;
            }
        }
        return null;
    }
}
