Feature: Login
  @TC1
  Scenario: User logins successfully with valid email and password
    Given User navigates to iresource website
    When User logins with valid email and password
    And User waits until Log out button is displayed
    And User clicks on Logout button
    Then The Login page title is displayed correctly

  @TC2
  Scenario: User cannot login without entering email
    Given User navigates to iresource website
    When User enters valid password
    And User clicks on Login button
    Then Required error is displayed below email field

  @TC3
  Scenario: User cannot login without entering password
    Given User navigates to iresource website
    When User enters valid email
    And User clicks on Login button
    Then Required error is displayed below password field

  @TC4
  Scenario: User cannot login without entering email and password
    Given User navigates to iresource website
    When User clicks on Login button
    Then Required error is displayed below email field
    And Required error is displayed below password field

  @TC5
  Scenario: Default status of Remember Me is uncheck
    Given User navigates to iresource website
    Then Remember Me is uncheck

  @TC6
  Scenario: Default status of password is crossed
    Given User navigates to iresource website
    When User enters valid password
    Then Password is crossed

  @TC7
  Scenario: User clicks on Eye button, password is displayed
    Given User navigates to iresource website
    When User enters valid password
    And User clicks on Eye button
    Then Password is displayed

  @TC8
  Scenario: I want to login with data from external data
    Given User navigates to iresource website
    When User logins with valid email and password from external data
    And User waits until Log out button is displayed
    Then User clicks on Logout button