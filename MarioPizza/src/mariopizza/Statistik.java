
package mariopizza;

import java.util.ArrayList;


public class Statistik {
    private  ArrayList <Bestilling> bestillinger = new ArrayList();
    private  ArrayList <Kunde> kunder = new ArrayList();
    
    public void addKunde(Kunde kunde){
        kunder.add(kunde);
    }

    public boolean checkKunde(int tlfnr){
        for (Kunde kunde: kunder) {
            if(kunde.getNummer() == tlfnr){
                return false;
            }
        }
        return true;
    }
    
    public void addBestilling(Bestilling bestilling){
        bestillinger.add(bestilling);
    }
    
    public  void printBestilling(){
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling.getTid() + " , " + bestilling.printBes() + " " + bestilling.getKunde().getNavn());
           
        }
    }
}
