package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Pizza;

public class DBCallsPizza {

    public static void insertToPizza(String navn, double pris, String fyld) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "insert into pizza values (null,'" + navn + "'," + pris + ",'" + fyld + "');";
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

    public static void deleteFromPizza(int id) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "delete from pizza where pizza_id=" + id + ";";
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

    public static void selectAllPizza() {

        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "SELECT * FROM pizza";
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
//            int id = resultSet.getInt("order_id");
                String navn = resultSet.getString("pizza_navn");
                double pris = resultSet.getDouble("pizza_pris");
                String fyld = resultSet.getString("pizza_fyld");

                Pizza tempPizza = new Pizza(navn, pris, fyld);
                ArrayListHolder.addPizza(tempPizza);
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
