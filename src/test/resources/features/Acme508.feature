Feature: ACME 508 Tests

  @508
  Scenario: Attest 508 testing
    Given i open the ACME home page
    When i login with username <username> and password <password>
    Then i verify that i am logged in