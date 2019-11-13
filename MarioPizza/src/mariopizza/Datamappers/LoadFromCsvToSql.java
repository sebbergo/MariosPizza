package mariopizza.Datamappers;

import java.io.File;
import java.util.Scanner;
import mariopizza.Model.Pizza;
import mariopizza.Util.ArrayListHolder;

public class LoadFromCsvToSql {

    public static void loadFromCsv() {
        File file = new File("Data/Pizzaer.csv");
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] pizzaer = line.split(";");
                String navn = pizzaer[0];
                double pris = Double.parseDouble(pizzaer[1]);
                String[] fyld = new String[pizzaer.length - 2];
                for (int i = 0; i < fyld.length; i++) {
                    fyld[i] = pizzaer[i + 2];
                }

                makePizza(navn, pris, fyld);
            } //laver en try catch, for at finde csv filen.
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public static void makePizza(String navn, double pris, String[] fyld) {
        String fyldString = "";
        for (int i = 0; i < fyld.length; i++) {
            fyldString += fyld[i] + ",";
        }
        Pizza tempPizza = new Pizza(navn, pris, fyldString);
        ArrayListHolder.addPizza(tempPizza);
    }
}
