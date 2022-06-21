
@Regression @smoke @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And
  dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background: for the scenarios in the feature file, user us expected to be on user login page
    Given user is on the library login page
    # Background and Given have the same function as pre-condition for scenarios below


  @librarian @employee @wip
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard


  @student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard


  @admin  @employee
  Scenario: Login as admin
    When users enters admin username
    And user enters admin password
    Then  user should see the dashboard
    # used for adding comments