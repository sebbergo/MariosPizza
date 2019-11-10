package mariopizza;
//@author Lukas
//import mariopizza.Controller.Controller;

import GUI.NewJFrame;
import mariopizza.Datamappers.SqlWriter;
import java.util.ArrayList;
import mariopizza.Model.Pizza;
import mariopizza.Util.DBCalls;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;

public class MarioPizza {

    public static void main(String[] args) {
//       læser csv filen pizzaer og tilføjer dem
        //Menukort.menukortLoad();
        //Skriver alle pizzaer ind i tabelen
        //SqlWriter.insretPizzaFromCsv();
        
        load();
        Menukort.printMenukort();
        
        NewJFrame menu = new NewJFrame();
        menu.setVisible(true);
        

        //  Controller.run();
    }

    public static void load() {
        DBCalls.selectAllPizza();
        Statistik.StatLoad();
    }
}
