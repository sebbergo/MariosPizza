package mariopizza.DataMappers; 

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import mariopizza.Model.Bestilling;
import mariopizza.Util.DBConnection;
import mariopizza.View.Statistik;


public class DBBestilling {
    public static void bestillingTilSQL() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("USE mariopizza;");
        statement.executeUpdate("DELETE FROM Bestilling;");
        statement.executeUpdate("ALTER TABLE Bestilling AUTO_INCREMENT = 1;");
        String bestillingCSV = "Data/Bestillinger.csv";
        File file = new File(bestillingCSV);

        try {
            Scanner myScan = new Scanner(file);
            String line = "";
            while (myScan.hasNext()) {
                line = myScan.nextLine();
                String[] bestillinger = line.split(";");
                String tid = bestillinger[0];
                String navn = bestillinger[1];
                int tlf = Integer.parseInt(bestillinger[2]);
                String[] pizzaArr = new String[bestillinger.length - 3];
                for (int i = 0; i < pizzaArr.length; i++) {
                    pizzaArr[i] = bestillinger[i + 3];
                }
                String pizzaNr = Arrays.toString(pizzaArr);
                pizzaNr = pizzaNr.substring(1, pizzaNr.length() - 1);
                pizzaNr = pizzaNr.replaceAll(" ", "");

                statement.executeUpdate("INSERT INTO Bestilling (TidAfh, PizzaNr, Navn, Tlf)"
                        + "VALUES ('" + tid + "', '" + pizzaNr + "', '" + navn + "', '"+ tlf +"')");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }

    }
    
    public static void loadBestillingerFraSQL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Bestilling");
        
        while(resultSet.next()) {
            String TidAfh = resultSet.getString("TidAfh");
            String PizzaNr = resultSet.getString("PizzaNr");
            String Navn = resultSet.getString("Navn");
            int Tlf = resultSet.getInt("Tlf");
            
            Bestilling tmpBestilling = new Bestilling(TidAfh, PizzaNr, Navn, Tlf);
            
            Statistik.addBestilling(tmpBestilling);
        }
    }
    
    public static void fjernBestillingFraSQL(int ID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate("DELETE FROM Bestilling WHERE ID = '"+ ID +"'");
    }
    
    public static void tilføjBestillingTilSQL(String tid, String pizzaNr, String navn, int tlf) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        
        if(tlf != 0){
        statement.executeUpdate("INSERT INTO Bestilling (TidAfh, PizzaNr, Navn, Tlf)"
                + "VALUES ('" + tid + "', '" + pizzaNr + "', '" + navn + "', '"+ tlf +"')");
        }else{
        statement.executeUpdate("INSERT INTO Bestilling (TidAfh, PizzaNr, Navn)"
            + "VALUES ('" + tid + "', '" + pizzaNr + "', '" + navn + "')");
        }
    }
    
    public static void printBestillingerFraSQL() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        
        resultSet = statement.executeQuery("SELECT * FROM Bestilling");
        
        while(resultSet.next()) {
        System.out.print(resultSet.getString("TidAfh") + ": ");
        System.out.print(resultSet.getString("PizzaNr") + ", ");
        System.out.print(resultSet.getString("Navn") + " ");
        System.out.println("(" + resultSet.getInt("Tlf") + ")");
        }
    }
    
    public static void antalPizzaerKøbtFraSQL() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        
        resultSet = statement.executeQuery("SELECT * FROM Bestilling");
        
        ArrayList<String> pizzaNr = new ArrayList();
        String tmpres = "";
        
        while(resultSet.next()) {
            tmpres = resultSet.getString("PizzaNr");
            pizzaNr.add(tmpres);
        }
        
        
    }
    
    public static void bestillingerTilSQL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        String bestillingerCSV = "Data/Bestillinger.csv";
        File file = new File(bestillingerCSV);
        Scanner myScan = new Scanner(file);
        String line = "";

        while (myScan.hasNext()) {
            line = myScan.nextLine();
            String[] bestillinger = line.split(";");
            String tid = bestillinger[0];
            String navn = bestillinger[1];
            int tlfNummer = Integer.parseInt(bestillinger[2]);
            int pizzaID = Integer.parseInt(bestillinger[3]);

            statement.executeUpdate("INSERT INTO Bestilling VALUES ('" + tid + "', '" + navn + "', '" + tlfNummer + "', '" + pizzaID + "')");
        }

    }
}
