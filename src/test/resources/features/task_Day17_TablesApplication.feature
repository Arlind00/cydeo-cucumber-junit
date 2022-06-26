Feature: User should be able to login using correct credentials
  User story:
  As i user after entering valid credentials i should be able to have access to orders

  Background: user is on the login page
    Given user is at user login page


  Scenario: login as tester
    When  user enters username as "Test"
    And  user enters password as "Tester"
    And clicks to login button
    Then user should see url contains orders


  Scenario: login as tester
    When  user enters username "Test" password "Tester"and logins
    Then user should see url contains orders



  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders