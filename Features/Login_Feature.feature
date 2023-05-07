Feature:OrangeHRM
  Scenario: Logo verification on OrangeHRM webpage
    Given open the chrome web browser
    When OrangeHRM website is opened
    Then check OrangeHRM logo is present
    And close the browser