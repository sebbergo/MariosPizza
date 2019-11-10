package mariopizza.Datamappers;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SqlWriter {

    public static void writeSql() {
        File file = new File("Data/Pizzaer.csv");
        FileWriter fw;
        try {
            fw = new FileWriter("Data/pizzaSQL.sql");
            Scanner myScanner = new Scanner(file);
            String line = "";
            
            while (myScanner.hasNextLine()) {
                line = myScanner.nextLine();
                String[] pizzaer = line.split(";");
                String navn = pizzaer[0];
                int pris = Integer.parseInt(pizzaer[1]);
                String[] fyld = new String[pizzaer.length - 2];
                String res = "";
                res += "insert into pizza values (" + "null,'" + navn + "'," + pris + ",'";
                for (int i = 0; i < fyld.length; i++) {
                    res += pizzaer[i + 2] + ",";
                }
                res = res.substring(0, res.length() - 1);
                res += "');\n";
                fw.write(res);
                //skriv SQL HER!
                
            } //laver en try catch, for at finde csv filen.
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
