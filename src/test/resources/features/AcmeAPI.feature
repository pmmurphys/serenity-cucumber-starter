Feature: ACME API Features

  @API
  Scenario: GET /emps endpoint
    Given I get a 200 status from GET /emps endpoint
    
  @API
  Scenario: POST /emps endpoint
    Given I get a 200 status from POST /emps endpoint
   
     #@filters
  #Scenario Outline: Test Table Filters
    #Given i open the ACME home page
    #When i enter <field> into <filter> filter
    #Then <field> for the <filter> filter should be at the top of the list
#
    #Examples: 
      #| field | filter     |
      #| bob   | first name | 
    