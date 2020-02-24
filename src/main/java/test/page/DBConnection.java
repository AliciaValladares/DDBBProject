package test.page;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.Before;

import java.sql.*;

public class DBConnection {

    private Connection connect = null;
    private Statement statement = null;
    private Resultset resultSet = null;

    @Before
    public Connection setConnection() throws ClassNotFoundException, SQLException {

        String driverName = "com.mysql.cj.jdbc.Driver";
        String serverName = "172.18.44.27";
        String portNumber = "3308";
        String mydatabase = serverName + ":" + portNumber + "/voiceworks_core";
        String url = "jdbc:mysql://" + mydatabase;
        String userName = "vw_dev";
        String password = "UpcvJRxSEh1Bc0zd";

        Class.forName(driverName);
//        Setup the connection with the DB
        connect = DriverManager.getConnection(url, userName, password);
        System.out.println("connected");
        return connect;
    }

    public Statement checkData(String selectQuery) throws SQLException {
//        Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = (Resultset) statement.executeQuery(selectQuery);
        return statement;
    }

    public Resultset getData() throws SQLException {
        while (((ResultSet) resultSet).next()) {
            String price = ((ResultSet) resultSet).getString("price");
            System.out.println("The info is: " + price);
        }
        return resultSet;
    }

    public Statement insertData(String insertQuery) throws SQLException {
        statement = connect.createStatement();
        int row = statement.executeUpdate(insertQuery);
        if (row > 0)
            System.out.println("The data has been inserted.");
        else
            System.out.println("An error has occured.");
        return statement;
    }

    public Resultset getDataInserted(String selectQuery) throws SQLException {
        statement = connect.createStatement();
        resultSet = (Resultset) statement.executeQuery(selectQuery);

        if (((ResultSet) resultSet).next())
            System.out.println("The data inserted is: " + ((ResultSet) resultSet).getInt("price"));
        else
            System.out.println("No such user id is already registered");
        return resultSet;
    }

    public Statement updateData(String updateQuery) throws SQLException {
        statement = connect.createStatement();
        int data = statement.executeUpdate(updateQuery);
        if (data > 0)
            System.out.println("The last price has been updated.");
        else
            System.out.println("An error has occured.");
        return statement;
    }

    public Resultset getDataUpdated() throws SQLException {
        statement = connect.createStatement();
        String sql = "select price, startDate from ewanPrice where ewanVoiceworksProductId = 1200 and tariefPlanId = 1";
        resultSet = (Resultset) statement.executeQuery(sql);

        if (((ResultSet) resultSet).next())
            System.out.println("The new price is: " + ((ResultSet) resultSet).getInt("price") + " " + "and the startDate is: " +
                    ((ResultSet) resultSet).getTimestamp("startDate"));
        else
            System.out.println("No such user row is already registered");

        return resultSet;
    }

    public Statement deleteData(String deleteQuery) throws SQLException {
        statement = connect.createStatement();
        statement.executeUpdate(deleteQuery);
        return statement;
    }

    public Resultset getDataDeleted() throws SQLException {
        String sql = "select price, startDate from ewanPrice where ewanVoiceworksProductId = 1200 and tariefPlanId = 1";
        resultSet = (Resultset) statement.executeQuery(sql);
        if (((ResultSet) resultSet).next()){
            System.out.print("Data has not been deleted.");
        } else
        {
        System.out.println("Data has been deleted");
        }
        return resultSet;
    }

}
