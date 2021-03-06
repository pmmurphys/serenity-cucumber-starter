Feature: ACME API Features

  @API
  Scenario Outline: GET
    Given I get a 200 status from GET <endpoint>

    Examples:
    | endpoint |
    | null    |
    
  @API
  Scenario Outline: POST
    Given I get a 200 status from POST <endpoint>

    Examples:
      | endpoint |
      | null    |

    @API
    Scenario Outline: GET, deserialize, and store object
      Given I deserialize and store object from GET <endpoint>

      Examples:
      | endpoint |
      | null     |

    