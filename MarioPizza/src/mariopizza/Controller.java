package mariopizza;

import java.util.Scanner;

public class Controller {

    public void run() {
        boolean exitValue = true;
        while(exitValue){
            if(){

            }else if()

        }
    }
    public static String getUserText(String skriv){
           Scanner myScan = new Scanner(System.in);
           System.out.println(skriv);
           String resultat = myScan.nextLine();
           return resultat;
    }
    public static int getUserNumber(String skriv){
           Scanner myScan = new Scanner(System.in);
           System.out.println(skriv);
           int resultat = myScan.nextInt();
           myScan.nextLine();
           return resultat;
    }

    public static void tilføjBestilling(String tid, String pizzaNummer, String navn, int tlfnr) {
        Bestilling bes;
        if (tlfnr == 0) {
            bes = new Bestilling(tid, pizzaNummer, navn);
        } else {
            bes = new Bestilling(tid, pizzaNummer, navn, tlfnr);
        }
        Statistik.addBestillingStat(bes);
        Statistik.addBestilling(bes);
    }

    public static void fjernBestilling(int id) {
        Bestilling bes = Statistik.bestillingChecker(id);
        if (bes != null) {
            Statistik.removeBestilling(bes);
        }
    }
}
