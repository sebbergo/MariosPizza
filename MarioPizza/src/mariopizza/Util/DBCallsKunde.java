package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Kunde;

public class DBCallsKunde {

    public static void insertToKunde(String navn, int tlf) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "insert into kunde values (null," + tlf + ",'" + navn + "');";
            statement = MyConnector.createStatement();
            statement.executeUpdate(query);

            statement.close();
            MyConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCallsPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBCallsPizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void selectAllKunder() {
        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            MyConnector = DBConnector.getConnector();
            String query = "SELECT * FROM kunde";
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
//            int id = resultSet.getInt("pizza_id");
                int tlf = resultSet.getInt("kunde_tlf");
                String navn = resultSet.getString("kunde_navn");
                
                if (tlf == 0){
                    Kunde tempKunde = new Kunde(navn);
                    ArrayListHolder.addKunde(tempKunde);
                }else if (ArrayListHolder.checkKundeTlf(tlf) != null) {
                    ArrayListHolder.checkKundeTlf(tlf).setNavn(navn);
                } else {
                    Kunde tempKunde = new Kunde(tlf, navn);
                    ArrayListHolder.addKunde(tempKunde);
                }
            }

            //lukker
            resultSet.close();;
            statement.close();
            MyConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCallsPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBCallsPizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
