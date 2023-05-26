Feature: Sorting Products

  @Smoke @Sorting
    Scenario: Sorting products
    Given I on SauceDemo HomePage
    When I sort the products by name (A-Z)
    Then The products should be displayed in alphabetical order
    When I sort the products by name (Z-A)
    Then The products should be displayed in reverse alphabetical order
    When I sort the products by lowest price
    Then The products should be displayed in ascending order of price
    When I sort the products by highest price
    Then The products should be displayed in descending order of price