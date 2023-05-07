Feature: Customer details
    Background: Common Steps
      Given User opens chrome browser
      When User enters nopcommerce website url "https://admin-demo.nopcommerce.com/login"
      And User enters Email as "admin@yourstore.com" and Password as "admin"
      And User click login button
      When User click on Customer tab
      And User click on customers menu
      @sanity
    Scenario: Search a emailid
      When User enters emailid
      And user click on search button
      Then User emailid info displayed
      When User click log out button
      Then Page title should be "Your store. Login"
      And close the browser

        @regression
      Scenario: Search a Name
        When user enters firstname and lastname
        And user click on search button
        Then User name info displayed
        When User click log out button
        Then Page title should be "Your store. Login"
        And close the browser



