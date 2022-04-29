Feature: Login
  @TC1
  Scenario Outline: User logins successfully with valid email and password
    Given User navigates to iresource website
    When User logins with "<validEmail>" and "<validPassword>"
    And User waits until Log out button is displayed
    And User clicks on Logout button
    Then The Login Page "<title>" is displayed correctly
    Examples:
    |validEmail|validPassword|title|
    |iresource_test1@yopmail.com|Aa@123456|Log In |

  @TC2
  Scenario Outline: User cannot login without entering email
    Given User navigates to iresource website
    When User enters "<validPassword>"
    And User clicks on Login button
    Then "<requiredError>" is displayed correctly below email field
    Examples:
    |validPassword|requiredError|
    |Aa@123456    |Required!    |

  @TC3
  Scenario Outline: User cannot login without entering password
    Given User navigates to iresource website
    When User enters only "<validEmail>"
    And User clicks on Login button
    Then "<requiredError>" is displayed correctly below password field
    Examples:
    |validEmail|requiredError|
    |iresource_test1@yopmail.com|Required!|

  @TC4
  Scenario Outline: User cannot login without entering email and password
    Given User navigates to iresource website
    When User clicks on Login button
    Then "<requiredError>" is displayed correctly below email field
    And "<requiredError>" is displayed correctly below password field
    Examples:
    |requiredError|
    |Required!    |

  @TC5
  Scenario: Default status of Remember Me is uncheck
    Given User navigates to iresource website
    Then Remember Me is uncheck

  @TC6
  Scenario Outline: Default status of password is crossed
    Given User navigates to iresource website
    When User enters "<validPassword>"
    Then Password is crossed
    Examples:
    |validPassword|
    |Aa@123456    |

  @TC7
  Scenario Outline: User clicks on Eye button, password is displayed
    Given User navigates to iresource website
    When User enters "<validPassword>"
    And User clicks on Eye button
    Then Password is displayed
    Examples:
      |validPassword|
      |Aa@123456    |

  @TC9
  Scenario Outline: User logins successfully with these examples of email and password
    Given User navigates to iresource website
    When User logins with "<email>" and "<password>" from example
    And User waits until Log out button is displayed
    Then User clicks on Logout button
    Examples:
    |email|password|
    |iresource_test1@yopmail.com|Aa@123456|
    |iresource_test2@yopmail.com|Aa@123456|

  @TC10
  Scenario Outline: User is navigated to Forgot Password page when user clicks on Forgot Password hyperlink
    Given User navigates to iresource website
    When User clicks on Forgot Password hyperlink
    And User waits until Reset Your Password page is displayed
    Then The Reset Your Password Page "<title>" is displayed correctly
    Examples:
    |title|
    |Reset your Password|

  @TC11
  Scenario Outline: User is navigated to Sign Up page when user clicks on Sign Up Here hyperlink
    Given User navigates to iresource website
    When User clicks on Sign Up Here hyperlink
    And User waits until Sign Up page is displayed
    Then The Sign Up page "<title>" is displayed correctly
    Examples:
    |title|
    |Sign Up|

  @TC12
 Scenario Outline: User checks on Remember Me and logins, the login information are saved correctly
    Given User navigates to iresource website
    When User logins with "<validEmail>" and "<validPassword>" and checks Remember Me
    And User waits until Log out button is displayed
    And User clicks on Logout button
    And User clicks on Eye button
    Then The email information "<validEmail>" at attribute "<value>" is saved correctly
    And The password information "<validPassword>" at attribute "<value>" is saved correctly
    Examples:
      |validEmail|validPassword|value|
      |iresource_test1@yopmail.com|Aa@123456|value|

  @TC13
  Scenario Outline: User logins with incorrect email, "Email or password is invalid" error is displayed
    Given User navigates to iresource website
    When User logins with "<incorrectEmail>" and the "<validPassword>"
    And User waits until 'Email or password is invalid' error is displayed
    Then Email or password is invalid "<error>" is displayed correctly
    Examples:
    |incorrectEmail|error|validPassword|
    |iresource_test@mail.com|Email or password is invalid.|Aa@123456|

  @TC14
  Scenario Outline: User logins with incorrect password, "Email or password is invalid" is displayed
    Given User navigates to iresource website
    When User logins with the "<validEmail>" and "<incorrectPassword>"
    And User waits until 'Email or password is invalid' error is displayed
    Then Email or password is invalid "<error>" is displayed correctly
    Examples:
    |validEmail|incorrectPassword|error|
    |iresource_test@mail.com|Aa@123123|Email or password is invalid.|

  @TC15
  Scenario Outline: User logins with incorrect email and password, "Email or password is invalid" is displayed
    Given User navigates to iresource website
    When User logins with the "<incorrectEmail>" and the "<incorrectPassword>"
    And User waits until 'Email or password is invalid' error is displayed
    Then Email or password is invalid "<error>" is displayed correctly
    Examples:
      |incorrectEmail|incorrectPassword|error|
      |iresource_test@mail.com|Aa@123123|Email or password is invalid.|