Feature: API Testing on https://airportgap.com/

  Scenario: Get list of my favourite airport while VIE entered
    Given I am authorized user
    Then list of my favourite airports contains VIE airport
