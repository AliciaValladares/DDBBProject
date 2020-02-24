package test.glue;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.page.DBConnection;

import java.sql.*;

public class UpdateInformation {

    private Connection connect = null;
    private Statement statement = null;
    private Resultset resultSet = null;
    private DBConnection dbConnection = new DBConnection();

//    @Given("I am in the database")
//    public void i_am_in_the_database() throws SQLException, ClassNotFoundException {
//        connect = dbConnection.setConnection();
//    }

    @When("I update the data {string}")
    public void i_update_the_data(String updateQuery) throws SQLException {
        statement = dbConnection.updateData(updateQuery);
    }

    @Then("I get the new information")
    public void i_get_the_new_information() throws SQLException {
        resultSet = dbConnection.getDataUpdated();
    }

}

