package test.glue;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.page.DBConnection;

import java.sql.*;

public class DeleteInformation {

    private Connection connect = null;
    private Statement statement = null;
    private Resultset resultSet = null;
    private DBConnection dbConnection = new DBConnection();


//    @Given("I am in the database")
//    public void i_am_in_the_database() throws ClassNotFoundException, SQLException {
//        connect = dbConnection.setConnection();
//    }

    @When("I delete information {string}")
    public void i_delete_information(String deleteQuery) throws SQLException {
        statement = dbConnection.deleteData(deleteQuery);
    }

    @Then("The information deleted is not shown")
    public void the_information_deleted_is_not_shown() throws SQLException {
        resultSet = dbConnection.getDataDeleted();
    }
}
