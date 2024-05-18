@GroovyCheck
Feature: Learn to use groovy json path in evaluation of restassured

  @GetCheckWithGroovy
  Scenario Outline: Send get request and validate response using different type of Groovy json path
    Given I send request to reqres on "<page>"
    When The response contains statuscode "<status code>"
    Then the page node have the same value as "<page>"
    And count of object in data array is equal to value in per_page
    And print first name of all user in data
    And print user whose id is greater than "<id>"

    Examples: 
      | page | status code | id |
      |    1 |         200 |  3 |
    #  |    2 |         200 |  9 |
      
# https://groovy-lang.org/processing-xml.html#_gpath
