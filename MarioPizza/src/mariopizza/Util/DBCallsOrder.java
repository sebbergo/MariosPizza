package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Controllers.Controller;
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
            
            double pris = Controller.beregnenOrderPris(pizzaer);
            
            pizzaer = pizzaer.substring(0, pizzaer.length() - 1);
            String query = "insert into bestilling values (null," + kundeId + ",'" + tid + "','" + pizzaer + "'," + pris + ");";
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
            String query = "SELECT * FROM bestilling";
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);
            
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
//            int id = resultSet.getInt("pizza_id");
                String tid = resultSet.getString("order_tid");
                int kundeId = resultSet.getInt("kunde_id");
                
                String pizzaer = resultSet.getString("order_pizzaer");
                String fyld = resultSet.getString("order_pris");

                Bestilling tempBes = new Bestilling(tid, pizzaer, Statistik.getKunder().get(kundeId - 1).getNavn() , Statistik.getKunder().get(kundeId - 1).getNummer());

                Statistik.addBestilling(tempBes);
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
