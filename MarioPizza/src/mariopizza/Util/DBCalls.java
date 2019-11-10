package mariopizza.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariopizza.Model.Pizza;

public class DBCalls {

    public static void insert(String table, String navn, int pris, String fyld) {

        Connection MyConnector = null;
        Statement statement = null;
        try {
            MyConnector = DBConnector.getConnector();
            String query = "insert into " + table + " values (null,'" + navn + "'," + pris + ",'" + fyld + "');";
            statement = MyConnector.createStatement();
            statement.executeUpdate(query);

            statement.close();
            MyConnector.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCalls.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBCalls.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lukker
    }
    
        public static ArrayList <Pizza> selectAllPizza(String table) throws SQLException, SQLException, ClassNotFoundException{
        ArrayList returnList = new ArrayList();
        
        Connection MyConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        MyConnector = DBConnector.getConnector();
        String query = "SELECT * FROM " + table;
        statement = MyConnector.createStatement();
        resultSet = statement.executeQuery(query);
        
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            int movieId = resultSet.getInt("movie_id");
            String movieTitle = resultSet.getString("movie_title");
            String director = resultSet.getString("director");
            String year = resultSet.getString("year");
            String genreId = resultSet.getString("genre_id");
            
            Pizza tempMovie = new Pizza(movieId, movieTitle, director, year);
            returnList.add(tempMovie);
        }

        //lukker
        resultSet.close();;
        statement.close();
        MyConnector.close();

        
        return returnList;
    }
}
