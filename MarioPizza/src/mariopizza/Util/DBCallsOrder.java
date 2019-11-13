package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Controllers.Controller;
import mariopizza.Model.Bestilling;

public class DBCallsOrder {

    public static void deleteFromPizza(int id) {
        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "delete from bestilling where order_id=" + id + ";";
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

    public static void updateStatus(Bestilling bes, String status) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();

            String query = "update bestilling set `order_status` = '" + status + "'where order_id =" + (bes.getId()) + " ;";
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

    public static void insertToOrder(String tid, int kundeId, String pizzaer) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();

            double pris = Controller.beregnenOrderPris(pizzaer);
            String status = "Bestilit";

            pizzaer = pizzaer.substring(0, pizzaer.length() - 1);
            String query = "insert into bestilling values (null," + kundeId + ",'" + tid + "','" + pizzaer + "'," + pris + ",'" + status + "');";
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
                int id = resultSet.getInt("order_id");
                String tid = resultSet.getString("order_tid");
                int kundeId = resultSet.getInt("kunde_id");

                String pizzaer = resultSet.getString("order_pizzaer");
                String fyld = resultSet.getString("order_pris");
                String status = resultSet.getString("order_status");

                Bestilling tempBes = new Bestilling(tid, pizzaer, ArrayListHolder.getKunder().get(kundeId - 1).getNavn(), ArrayListHolder.getKunder().get(kundeId - 1).getNummer(), status, id);

                ArrayListHolder.addBestilling(tempBes);
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

    public static ArrayList<Bestilling> selectAllOrdersOrderedByTime() {
        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Bestilling> bestillinger = new ArrayList();
        Bestilling.setCounter(0);

        try {
            MyConnector = DBConnector.getConnector();
            String query = "SELECT * FROM bestilling order by order_tid";
            statement = MyConnector.createStatement();
            resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                int id = resultSet.getInt("order_id");
                String tid = resultSet.getString("order_tid");
                int kundeId = resultSet.getInt("kunde_id");

                String pizzaer = resultSet.getString("order_pizzaer");
                String fyld = resultSet.getString("order_pris");
                String status = resultSet.getString("order_status");

                Bestilling tempBes = new Bestilling(tid, pizzaer, ArrayListHolder.getKunder().get(kundeId - 1).getNavn(), ArrayListHolder.getKunder().get(kundeId - 1).getNummer(), status, id);

                bestillinger.add(tempBes);
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
        return bestillinger;
    }
}
