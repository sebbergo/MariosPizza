package mariopizza;
//@author Lukas
//import mariopizza.Controller.Controller;

import GUI.NewJFrame;
import mariopizza.Datamappers.SqlWriter;
import java.util.ArrayList;
import mariopizza.Util.DBCalls;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;

public class MarioPizza {

    public static void main(String[] args) {
        Menukort.menukortLoad();
        Statistik.StatLoad();
        
        SqlWriter.writeSqlFromPizzaCsv();
        
        NewJFrame menu = new NewJFrame();
        menu.setVisible(true);

        //  Controller.run();
    }
}
