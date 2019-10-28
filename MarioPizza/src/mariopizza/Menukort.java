package mariopizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menukort {

    private static ArrayList<Pizza> allePizzaer = new ArrayList();
    private String filename = "Data/Pizzaer.csv";
    public Menukort() {
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
                for(int i = 0; i < fyld.length; i++) fyld[i] = pizzaer[i+2];
                
                makePizza(navn, pris, fyld);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void addPizzaToCsv(String navn, int pris, String fyld){
        Pizza pizza = new Pizza(navn, pris, fyld);
        allePizzaer.add(pizza);
        
    
    }
    
    public void gemCsv() throws IOException{
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        for (Pizza pizza : allePizzaer) {
        fw.write(pizza.getNavn()+";");
        fw.write(pizza.getPris()+";");
        String[] fyld = pizza.getFyld().split(",");
        for(int i=0;i<fyld.length;i++){
            fw.write(fyld[i]+";");
        }
        fw.write("\n");
        }
        fw.close();

    }
    public void makePizza(String navn, int pris,String[] fyld){
        
        String fyldString = "";
        for (int i = 0; i < fyld.length; i++) {
        fyldString += fyld[i] + ",";
        }
        Pizza pep = new Pizza(navn, pris, fyldString);
        addPizza(pep);        
    }

    public void addPizza(Pizza pizza) {
        allePizzaer.add(pizza);
    }

    public static void printPizza() {
        for (Pizza pizza : allePizzaer) {
            System.out.println(pizza.getFyld());
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

    public void readFile(String filename) {
  
    }

}
