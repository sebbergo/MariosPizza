package mariopizza.View;

import mariopizza.Model.Pizza;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.DataMappers.DBMenukort;

public class Menukort {

    private static ArrayList<Pizza> allePizzaer = new ArrayList();
    private static String filename = "Data/Pizzaer.csv";
        //Loader menukort fra csv filen Pizzaer.csv og splitter linjerne ved hvert ;
    public static void menukortLoad() {
        File file = new File(filename);
        try {
            Scanner myScanner = new Scanner(file);
            String line = "";
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] pizzaer = line.split(";");
                String navn = pizzaer[0];
                int pris = Integer.parseInt(pizzaer[1]);
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
        //sletter en linje, ved at fjerne en linej og printe csv igen uden slettede linje
    public static void sletLine(int line) {
        removePizza(line);
        gemPizzaCsv();
    }

    public static void addPizzaToCsv(String navn, int pris, String fyld) throws ClassNotFoundException, SQLException {
        Pizza pizza = new Pizza(navn, pris, fyld);
        allePizzaer.add(pizza);
        
        DBMenukort.menukortTilSQL();
    }

    public static void gemPizzaCsv() {
        File file = new File(filename);
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            for (Pizza pizza : allePizzaer) {
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
            Logger.getLogger(Menukort.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void makePizza(String navn, int pris, String[] fyld) {

        String fyldString = "";
        for (int i = 0; i < fyld.length; i++) {
            fyldString += fyld[i] + ",";
        }
        Pizza pep = new Pizza(navn, pris, fyldString);
        addPizza(pep);
    }

    public static void addPizza(Pizza pizza) {
        allePizzaer.add(pizza);
    }
    
    public static void removePizza(int id){
        allePizzaer.remove(pizzaChecker(id));
    }

    public static void printPizza() {
        for (Pizza pizza : allePizzaer) {
            System.out.println(pizza.getNummer()+": " + pizza.getNavn());
        }
    }
    

    public static Pizza pizzaChecker(int nummer) {
        for (Pizza pizza : allePizzaer) {
            if (pizza.getNummer() == nummer) {
                return pizza;
            }
        }
        return null;
    }

    
    public static void printMenukort() {
        String pizzaPrint = "";
        for (Pizza pizza : allePizzaer) {
            pizzaPrint = pizza.getNummer() + ": " + pizza.getNavn() + ", " + pizza.getFyld() + " Pris: " + pizza.getPris();
            System.out.println(pizzaPrint);
        }
    }

    public static ArrayList getAllePizzaer(){
        return allePizzaer;
    }
    

}
