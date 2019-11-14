package mariopizza.DataMappers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import mariopizza.Model.Pizza;
import mariopizza.Util.DBConnection;
import mariopizza.View.Menukort;

public class DBMenukort {

    String navn = "";
    int pris = 0;
    String fyld = "";

    public static void menukortTilSQL() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("USE mariopizza;");
        statement.executeUpdate("DELETE FROM Pizza;");
        statement.executeUpdate("ALTER TABLE Pizza AUTO_INCREMENT = 1;");
        String pizzaCSV = "Data/Pizzaer.csv";
        File file = new File(pizzaCSV);

        try {
            Scanner myScan = new Scanner(file);
            String line = "";
            while (myScan.hasNext()) {
                line = myScan.nextLine();
                String[] pizzaer = line.split(";");
                String navn = pizzaer[0];
                int pris = Integer.parseInt(pizzaer[1]);
                String[] fyldArr = new String[pizzaer.length - 2];
                for (int i = 0; i < fyldArr.length; i++) {
                    fyldArr[i] = pizzaer[i + 2];
                }
                String fyld = Arrays.toString(fyldArr);
                fyld = fyld.substring(1, fyld.length() - 1);

                statement.executeUpdate("INSERT INTO Pizza (Navn, Pris, Fyld)"
                        + "VALUES ('" + navn + "', '" + pris + "', '" + fyld + "')");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }

    }

    public static void printMenukortFraSQL() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;

        resultSet = statement.executeQuery("SELECT * FROM Pizza");

        while (resultSet.next()) {
            System.out.print(resultSet.getInt("ID") + ": ");
            System.out.println(resultSet.getString("Navn"));
        }
    }

    public static void tilføjPizzaTilSQL(String navn, int pris, String fyld) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO Pizza (Navn, Pris, Fyld)"
                + "VALUES ('" + navn + "', '" + pris + "', '" + fyld + "')");
    }

    public static void fjernPizzaFraSQL(int ID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate("DELETE FROM Pizza WHERE ID = '" + ID + "'");
    }
    
    public static void loadPizzaerFraSQL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Pizza");
        int counter = 0;
        
        while(resultSet.next()) {
            counter++;
            String navn = resultSet.getString("Navn");
            int pris = resultSet.getInt("Pris");
            String fyld = resultSet.getString("Fyld");
            
            Pizza tmpPizza = new Pizza(navn, pris, fyld);
            
            Menukort.addPizza(tmpPizza);
        }
    }
    
    public static void visMenukortFraSQL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Pizza");
        
        while(resultSet.next()) {
            System.out.print("\n" + resultSet.getInt("ID") + ", ");
            System.out.print(resultSet.getString("Navn") + ", ");
            System.out.print(resultSet.getInt("Pris") + ", ");
            System.out.print(resultSet.getString("Fyld") + ".");
        }
    }
    
    
}
