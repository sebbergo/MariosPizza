package mariopizza.Util;
//@author Lukas

import mariopizza.Controllers.Controller;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Kunde;
import mariopizza.Model.Pizza;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayListHolder {

    //path til vores csv-fil der holder på bestillinger
    private static String filename = "Data/Bestillinger.csv";
    //oprettelse af arraylists, til statistik, bestillinger og kunder
    private static ArrayList<Pizza> allePizzaer = new ArrayList();
    private static ArrayList<Kunde> kunder = new ArrayList();
    private static ArrayList<Bestilling> bestillingerStat = new ArrayList();
    private static ArrayList<Bestilling> bestillinger = new ArrayList();

    //metode der checker om en given kundes telefonnummer allerede eksistere under
    //andet navn, og retunere nyt navn til samme nummer
    public static Kunde checkKunde(int tlfnr) {
        for (Kunde kunde : kunder) {
            if (kunde.getNummer() == tlfnr) {
                return kunde;
            }
        }
        return null;
    }

    //Vi checker at det er den rigtige pizza vha. dens id, fordi vi ikke
    //kan oprette objekter at referere til
    public static Bestilling bestillingChecker(int id) {
        for (Bestilling bes : bestillinger) {
            if (bes.getId() == id) {
                return bes;
            }
        }
        return null;
    }

    public static Pizza pizzaChecker(int nummer) {
        for (Pizza pizza : allePizzaer) {
            if (pizza.getNummer() == nummer) {
                return pizza;
            }
        }
        return null;
    }

    //Fjerner og tilføjer bestillinger
    public static void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public static void removeBestilling(Bestilling bestilling) {
        bestillinger.remove(bestilling);
    }

    //fjerner/tilføjer bestillinger til statistik
    public static void addBestillingStat(Bestilling bestilling) {
        bestillingerStat.add(bestilling);
    }

    //sortere vores bestillinger efter tid vha. vores compareTo metode i Bestilling.java
    public static void bestillingerEfterTid() {
        Collections.sort(bestillinger);
    }

    public static void addPizza(Pizza pizza) {
        allePizzaer.add(pizza);
    }

    public static void removePizza(int id) {
        allePizzaer.remove(pizzaChecker(id));
    }

    public static ArrayList<Pizza> getAllePizzaer() {
        return allePizzaer;
    }

    // metode der tilføjer kunde til vores kunder-arraylist
    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    public static ArrayList<Kunde> getKunder() {
        return kunder;
    }

    public static ArrayList<Bestilling> getBestillingerStat() {
        return bestillingerStat;
    }

    public static ArrayList<Bestilling> getBestillinger() {
        return bestillinger;
    }
}
