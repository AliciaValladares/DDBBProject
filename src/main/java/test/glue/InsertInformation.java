package test.glue;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.page.DBConnection;

import java.sql.*;

public class InsertInformation {

    private Connection connect = null;
    private Statement statement = null;
    private Resultset resultSet = null;
    private DBConnection dbConnection = new DBConnection();


    @Given("I am in the database")
    public void i_am_in_the_database() throws SQLException, ClassNotFoundException {
        connect = dbConnection.setConnection();
    }

    @When("I insert data {string}")
    public void i_insert_data(String insertQuery) throws SQLException {
        statement = dbConnection.insertData(insertQuery);
    }

    @Then("the information inserted is {string}")
    public void the_information_inserted_is(String selectQuery) throws SQLException {
        resultSet = dbConnection.getDataInserted(selectQuery);
    }
}
