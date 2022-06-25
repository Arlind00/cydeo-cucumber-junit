Feature: Wikipedia search functionality and verification


  # optionally we can pass ticket number here


  @scenario1
  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And  User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  @scenario2
  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And  User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And  User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header

    Examples: values we are going to be using in this scenario is as below
      | searchValue    | expectedTitle  | expectedMainHeader |
      | Steve Jobs     | Steve Jobs     | Steve Jobs         |
      | Bob Marley     | Bob Marley     | Bob Marley         |
      | Chuck Norris   | Chuck Norris   | Chuck Norris       |
      | Antony Hopkins | Antony Hopkins | Antony Hopkins     |
      | Marie Currie   | Marie Currie   | Marie Currie       |

