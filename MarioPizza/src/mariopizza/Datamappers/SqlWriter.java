package mariopizza.Datamappers;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import mariopizza.Controllers.Controller;
import mariopizza.Model.Bestilling;
import mariopizza.Util.DBCallsKunde;
import mariopizza.Util.DBCallsOrder;
import mariopizza.Util.DBCallsPizza;
import mariopizza.Util.ArrayListHolder;

public class SqlWriter {

    public static void insretPizzaFromCsv() {
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
                String retFyld = "";
                for (int i = 0; i < fyld.length; i++) {
                    retFyld += pizzaer[i + 2] + ",";
                }
                retFyld = retFyld.substring(0, retFyld.length() - 1);
                DBCallsPizza.insertToPizza(navn, pris, retFyld);

            } //laver en try catch, for at finde csv filen.
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public static void insretOrderFromCsv() {
        File file = new File("Data/Bestillinger.csv");
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] bes = line.split(";");
                String tid = bes[0];
                int kundeId = Integer.parseInt(bes[1]);

                String pizzaer = "";
                for (int i = 2; i < bes.length; i++) {
                    pizzaer += bes[i] + ",";
                }

                DBCallsOrder.insertToOrder(tid, kundeId, pizzaer);

            }
        } catch (Exception e) {
            System.out.println("Error: Her" + e);
        }
    }

    public static void insretKundeFromCsv() {
        File file = new File("Data/kunder.csv");
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] bes = line.split(";");
                String navn = bes[0];
                int tlf = Integer.parseInt(bes[1]);

                DBCallsKunde.insertToKunde(navn, tlf);
            }
        } catch (Exception e) {
            System.out.println("Error: der" + e.toString());
        }
    }
}
