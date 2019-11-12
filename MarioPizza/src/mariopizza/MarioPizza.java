package mariopizza;
//@author Lukas
//import mariopizza.Controller.Controller;

import GUI.MainMenu;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import mariopizza.Datamappers.SqlWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;
import mariopizza.Util.DBCallsKunde;
import mariopizza.Util.DBCallsOrder;
import mariopizza.Util.DBCallsPizza;
import mariopizza.Util.DBConnector;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;
import static mariopizza.View.Statistik.pizzaerKøbAfKunde;

public class MarioPizza {

    public static void main(String[] args) {
//       læser csv filen pizzaer og tilføjer dem
        //Menukort.menukortLoad();

        //firstload();
        //load();

        Run run = new Run();
        run.setVisible(true);
        


    }
}
