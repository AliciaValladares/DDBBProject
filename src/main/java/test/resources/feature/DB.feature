Feature: As a developer, I want to get connected to the DB in order to get, update, insert or delete information.

  Background: DB connection established.
    Given I am in the database

  Scenario: Insert information in the DB.
    When I insert data "insert into ewanPrice (uuid, tariefplanId, ewanVoiceworksProductId, price, startDate, endDate, minContactPeriod, added_at, user_id) values ('4b591eab-2b91-10e9-92ef-f01fafd24d3a',1, 1200, 111, '3000-01-01', null, null, null, null)"
    Then the information inserted is "select price from ewanPrice where ewanVoiceworksProductId = 1200 and tariefPlanId = 1"

  Scenario: Get information from DB.
    When I check the data "select price, startDate from ewanPrice where ewanVoiceworksProductId = 1200 and tariefPlanId = 1"
    Then I get information

  Scenario: Update information in the DB.
    When I update the data "update ewanPrice set price = 1, startDate = '3000-09-29' where ewanVoiceworksProductId = 1200 and tariefPlanId = 1"
    Then I get the new information

  Scenario: Delete information in the DB.
    When I delete information "delete from ewanPrice where ewanVoiceworksProductId = 1200 and tariefPlanId = 1"
    Then The information deleted is not shown


