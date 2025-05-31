Feature: Login Feature

  Scenario: Successful login
    Given I am on the login page
    Given I am on the registration page
    When I enter a valid email address
    And I click on the "Create an account" button
    And I enter the following registration details:
      | Field      | Value       |
      | First Name | John        |
      | Last Name  | Doe         |
      | Password   | Password123 |
      | Day        | 25          |
      | Month      | 12          |
      | Year       | 1978        |