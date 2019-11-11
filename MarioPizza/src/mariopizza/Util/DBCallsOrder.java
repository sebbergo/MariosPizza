package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Bestilling;
import mariopizza.Model.Pizza;
import mariopizza.View.Menukort;
import mariopizza.View.Statistik;

public class DBCallsOrder {

    public static void insertToOrder(String tid, int kundeId, String pizzaer) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            
            double pris = 12;

//            String[] pizzaerSp = pizzaer.split(",");
//            int[] pizzaerNummer = new int[pizzaerSp.length];

//            for (int i = 0; i < pizzaerSp.length; i++) {
//                pris += Menukort.pizzaChecker(pizzaerNummer[i]).getPris();
//            }

            pizzaer = pizzaer.substring(0, pizzaer.length() - 1);
            String query = "insert into bestilling values (null," + kundeId + ",'" + tid + "','" + pizzaer + "'," + 12 + ");";
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

    public static void selectAllOrders() {
        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            MyConnector = DBConnector.getConnector();
            String query = "SELECT * FROM order";
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
//            int id = resultSet.getInt("pizza_id");
                String tid = resultSet.getString("order_tid");
                double pris = resultSet.getDouble("pizza_pris");
                String fyld = resultSet.getString("pizza_fyld");

//                Bestilling tempBes = new Bestilling(tid, );
//                (String tid, String pizzaNummer, String navn, int tlfnr)
//                Statistik.addBestilling(tempBes);
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
