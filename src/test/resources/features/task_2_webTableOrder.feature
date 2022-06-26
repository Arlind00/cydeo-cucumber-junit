Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "american express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table


  @wip
  Scenario Template: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipcode>"
    And user selects credit card type "<creditCardType>"
    And user enters credit card number "<creditCardNo>"
    And user enters expiry date "<expiringDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table
    @FemaleScientieses
    Examples: Famous female scientists
      | productType | quantity | customerName      | street    | city   | state   | zipcode | creditCardType | creditCardNo      | expiringDate | expectedName      |
      | MoneyCog    | 2        | Marie Curie       | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Marie Curie       |
      | MoneyCog    | 3        | Rosalind Franklin | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Rosalind Franklin |
      | MoneyCog    | 4        | Mie Mehmeti       | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Mie Mehmeti       |
      | MoneyCog    | 5        | Cat Woman         | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Cat Woman         |
    @MaleScientists
    Examples: Famous male scientists
      | productType | quantity | customerName    | street    | city   | state   | zipcode | creditCardType | creditCardNo      | expiringDate | expectedName    |
      | MoneyCog    | 2        | Nicola Tesla    | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Nicola Tesla    |
      | MoneyCog    | 3        | Albert Einstein | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Albert Einstein |
      | MoneyCog    | 4        | Galileo         | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Galileo         |
      | MoneyCog    | 5        | Isac Newton     | London st | London | England | 50505   | Visa           | 11122233344455566 | 12/13        | Isac Newton     |