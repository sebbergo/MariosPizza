package mariopizza.DataMappers; 

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import mariopizza.Util.DBConnection;


public class DBKunde {
    
    public static void tilføjKundeTilSQL(String navn, int tlfnr) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO Kunde (Navn, TlfNr)"
                + "VALUES ('" + navn + "', '" + tlfnr + "')");
    }
    
    public static void kunderTilSQL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        String bestillingerCSV = "Data/Bestillinger.csv";
        File file = new File(bestillingerCSV);
        Scanner myScan = new Scanner(file);
        String line = "";

        while (myScan.hasNext()) {
            line = myScan.nextLine();
            String[] kunder = line.split(";");
            String navn = kunder[1];
            int tlfNummer = Integer.parseInt(kunder[2]);

            statement.executeUpdate("INSERT INTO Kunde VALUES ('" + tlfNummer + "', '" + navn + "')");
        }

    }
    
}
