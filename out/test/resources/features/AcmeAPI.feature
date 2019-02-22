Feature: ACME API Features

  @API
  Scenario Outline: GET
    Given I get a 200 status from GET <endpoint>

    Examples:
    | endpoint |
    | /test    |
    
  @API
  Scenario Outline: POST
    Given I get a 200 status from POST <endpoint>

    Examples:
      | endpoint |
      | /test    |


    