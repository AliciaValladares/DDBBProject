package test.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import test.page.DBConnection;


import java.sql.*;


public class CheckInformation {


    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private DBConnection dbConnection = new DBConnection();

//    @Given("I am in the database")
//    public void i_am_in_the_database() throws SQLException, ClassNotFoundException {
//        connect = dbConnection.setConnection();
//    }

    @When("I check the data {string}")
    public void i_check_the_data(String selectQuery) throws SQLException {
        statement = dbConnection.checkData(selectQuery);
    }

    @Then("I get information")
    public void i_get_information() throws SQLException {
        resultSet = (ResultSet) dbConnection.getData();
    }
}

