Feature: Sign Up

  @TC1
  Scenario Outline: User can sign up an Internal Persona account successfully
    Given Navigate to Sign Up page
    When Generates randomly Firstname, Lastname with email "<domain>" and "<password>"
    And User enters valid data on each field
    And User clicks on Sign Up button
    And The Verify Email page is displayed with correct "<title>"
    And Navigate to email generating website by "<script>"
    And Enter verification code from the generating email website
    And User clicks on Confirm button
    And Account information is saved to file InternalPersonaAccounts.csv
    Then The Login page "<titlelogin>" is displayed correctly
    Examples:
    |domain|password|title|script|titlelogin|
    |@qa.team|Aa@123456|Verify Email|window.open('https://qa.team/','_blank');|Log In|