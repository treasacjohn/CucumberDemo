@GoogleSearch
Feature: Google Search feature
  I want to use this template for searching text in Google

  @GoogleSearchScenario1
  Scenario: Search text in Google
    Given I want to launch google.com
    When I enter text for search
    Then I verify that I am able to click on the available link
    And I navigate to search result page

  @GoogleSearchScenario2
  Scenario Outline: Search text in given browsers
    Given I want to launch browser <'browsername'>
    When I enter <'text'> for search
    Then I verify that I am able to click on the available link
    And I navigate to search <'result'> page

    Examples: 
      | browsername                  | text       | result                      |
      | https://www.google.com/      | Britannica | https://www.britannica.com/ |
      | https://in.search.yahoo.com/ | Britannica | https://www.britannica.com/ |
