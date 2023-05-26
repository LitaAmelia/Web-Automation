Feature: Login

  @Smoke @Positive @Login
    Scenario: Login with valid credentials
    Given I am on Login page
    When I fill username and password
    And I click login button
    Then I navigate to homepage

  @Smoke @Negative @Login
    Scenario Outline: Login with invalid credentials
    Given I am on Login page
    When I input <username> and <password>
    And I click login button
    Then I get login <result>

    Examples:
    | username | password | result |
    |  |  | blank field |
    | | secret_sauce | username blank |
    | standard_user |  | password blank |
    | standard_usser | invalid_password | missmatch |