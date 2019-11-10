package mariopizza.Datamappers;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import mariopizza.Util.DBCalls;

public class SqlWriter {

    public static void writeSqlFromPizzaCsv() {
        File file = new File("Data/Pizzaer.csv");
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] pizzaer = line.split(";");
                String navn = pizzaer[0];
                int pris = Integer.parseInt(pizzaer[1]);
                String[] fyld = new String[pizzaer.length - 2];
                String retFyld = "";
                for (int i = 0; i < fyld.length; i++) {
                    retFyld += pizzaer[i + 2] + ",";
                }
                retFyld = retFyld.substring(0, retFyld.length() - 1);
                DBCalls.insert("pizza", navn, pris, retFyld);
                
            } //laver en try catch, for at finde csv filen.
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
