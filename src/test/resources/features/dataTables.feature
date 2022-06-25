Feature: Examples of Cucumber data table implementation


  Scenario: List of fruits i like
    Then  user should see fruits i like
      | kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |