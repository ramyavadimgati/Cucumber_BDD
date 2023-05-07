Feature: Login nopcommerce
  @sanity
  Scenario: Login validation on nopcommerce webpage
    Given User opens chrome browser
    When User enters nopcommerce website url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And User click login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click log out button
    Then Page title should be "Your store. Login"
    And close the browser

    @regression
  Scenario Outline: Login_validate with multiple inputs
    Given User opens chrome browser
    When User enters nopcommerce website url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<Email>" and Password as "<Password>"
    And User click login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click log out button
    Then Page title should be "Your store. Login"
    And close the browser
    Examples:
    |Email| Password|
    |admin@yourstore.com  |     admin    |
    |admin@yourstore.com       |      admin123        |
