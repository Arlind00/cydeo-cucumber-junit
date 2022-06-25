Feature: User should be able to login using correct credentials
  User story:
  As i user after entering valid credentials i should be able to have access to orders



  Scenario: login as tester
    Given user is at user login page
    When  user enters username as "Test"
    And  user enters password as "Tester"
    And clicks to login button
    Then user should see url contains orders


  Scenario: login as tester
    Given user is at user login page
    When  user enters username "Test" password "Tester"and logins
    Then user should see url contains orders