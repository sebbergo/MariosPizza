package mariopizza.Datamappers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;
import mariopizza.View.ArrayListHolder;
import mariopizza.View.ArrayListHolder;

public class SaveToCsv {
    
    public static void gemAltTilCsv(){
        gemBestillingerCsv();
        gemKunderCsv();
        gemPizzaerCsv();
    }
    
    
    //Metode der hjælper med at gemme pizzaer i vores csv fil efter der bliver
    //ændret i den
    public static void gemBestillingerCsv() {
        File file = new File("Data/Bestillinger.csv");
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            for (Bestilling bes : ArrayListHolder.getBestillinger()) {
                fw.write(bes.getTid() + ";");
                fw.write(ArrayListHolder.getKunder().get(bes.getKundeId() - 1).getId() + ";");

                for (Pizza piz : bes.getPizza()) {
                    fw.write(piz.getNummer() + ";");
                }
                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(ArrayListHolder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gemKunderCsv() {
        File file = new File("Data/kunder.csv");
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            for (Kunde kunde : ArrayListHolder.getKunder()) {
                fw.write(kunde.getNavn() + ";");
                fw.write(kunde.getNummer() + ";");

                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(ArrayListHolder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void gemPizzaerCsv() {
        File file = new File("Data/Pizzaer.csv");
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            for (Pizza pizza : ArrayListHolder.getAllePizzaer()) {
                fw.write(pizza.getNavn() + ";");
                fw.write(pizza.getPris() + ";");
                String[] fyld = pizza.getFyld().split(",");
                for (int i = 0; i < fyld.length; i++) {
                    fw.write(fyld[i] + ";");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ArrayListHolder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
