package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static int selectKundeId(int tlf) {
        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        
        try {
            MyConnector = DBConnector.getConnector();
            String query = "SELECT kunde_id FROM kunde WHERE kunde_tlf=" + tlf;
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);
            
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                id = resultSet.getInt("kunde_id");
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
        return id;
    }
}
