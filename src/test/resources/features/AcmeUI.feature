Feature: ACME UI Tests

  @login
  Scenario Outline: Employee is authenticated
    Given i open the ACME home page
    When i login with username <username> and password <password>
    Then i should be on the homepage

    Examples: 
      | username                 | password  |
      | jeff.diederiks@gmail.com | peachjeff |

  @list
  Scenario: Employee is able to view the list of employees in the database
  Given i open the ACME home page

  @edit
  Scenario: Employee is able to edit their personal profile that has basic contact information (name, email, phone, and address) and their skills
  Given i open the ACME home page

  @UNLIMITED_SKILL
  Scenario: An unbounded number of skills can be provided and stored with the profile
  Given i open the ACME home page