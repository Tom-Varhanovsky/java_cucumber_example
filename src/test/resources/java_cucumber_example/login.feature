Feature: Login page on expandtesting.com

  Scenario: Successful login
    Given Login website is open
    When user enters username "practice" and password "SuperSecretPassword!"
    And user clicks login
    Then user is shown success alert
    And is shown secure area page

  Scenario: Unsuccessful login
    Given Login website is open
    When user enters username "practice" and password "WrongSecretPassword!"
    And user clicks login
    Then user is shown failure alert