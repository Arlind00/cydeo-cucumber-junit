Feature: Google search functionality
  Agile story: As a user, when i am on the Google search page i should be able to see
                whatever i want and see relevant information


  Scenario: Search page title verification
    When user is on Google search
    Then user should see title is Google

    @wip
    Scenario: Search functionality result title verification
      Given user is on Google search
      When user types apple and clicks enter
      Then user sees apple in the google title
