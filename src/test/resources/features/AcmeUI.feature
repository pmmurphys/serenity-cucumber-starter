Feature: ACME UI Tests

  @login
  Scenario Outline: Employee is authenticated
    Given i open the ACME home page
    When i login with username <username> and password <password>
    Then i verify that i am logged in

    Examples: 
      | username                 | password  |
      | jeff.diederiks@gmail.com | peachjeff |

  @list
  Scenario: Employee is able to view the list of employees in the database
    Given i open the ACME home page
    Then i verify the list of employees is visible

  @edit
  Scenario: Employee is able to edit their personal profile that has basic contact information (name, email, phone, and address) and their skills
    Given i open the ACME home page
    When i click the edit button of the first employee
    And i fill out edit fields with random infomation
    #And i edit first name to <fname>
    #And i edit last name to <lname>
    #And i edit email to <email>
    #And i edit phone to <phone>
    #And i edit addess to <address>
    And i click edit submit button
    Then i verify that employee infomation changed

  #Examples:
  #| fname | lname | email               | phone        | address                                 |
  #| John  | Smith | john.smith@acme.com | 555-555-5555 | 123 Main St., Washington, D.C. 22202    |
  #| Joe   | Shmo  | joe.shmo@acme.com   | 666-666-6666 | 321 Test Rd., New York City, N.Y. 24242 |
  @UNLIMITED_SKILL
  Scenario: An unbounded number of skills can be provided and stored with the profile
    Given i open the ACME home page
    When i click the name of the first employee
    Then i verify that i can view employee skills
