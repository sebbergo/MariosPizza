package mariopizza;
//@author Lukas
//import mariopizza.Controller.Controller;

import GUI.NewJFrame;
import mariopizza.Datamappers.SqlWriter;
import java.util.ArrayList;
import mariopizza.Model.Pizza;
import mariopizza.Util.DBCallsKunde;
import mariopizza.Util.DBCallsPizza;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;

public class MarioPizza {

    public static void main(String[] args) {
//       læser csv filen pizzaer og tilføjer dem
        //Menukort.menukortLoad();
        firstload();
        load();
        Menukort.printMenukort();

        DBCallsKunde.selectKundeId(1234);

        NewJFrame menu = new NewJFrame();
        menu.setVisible(true);

        //  Controller.run();
    }

    public static void load() {
        DBCallsPizza.selectAllPizza();
        Statistik.StatLoad();
    }

    public static void firstload() {
        //Skriver alle pizzaer ind i tabelen
        SqlWriter.insretPizzaFromCsv();
        SqlWriter.insretKundeFromCsv();
        SqlWriter.insretOrderFromCsv();
    }
}
