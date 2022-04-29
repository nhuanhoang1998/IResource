package Steps.Login;

import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
   LoginPage loginPage;

 @Given("^User navigates to iresource website$")
 public void userNavigatesToIresourceWebsite() {
  loginPage.open();
 }

 @And("^User clicks on Login button$")
 public void userClicksOnLoginButton() {
  loginPage.clickLoginButton();
 }

 @Then("^User clicks on Logout button$")
 public void userClicksOnLogoutButton() {
  loginPage.clickLogoutButton();
 }

 @Then("^Remember Me is uncheck$")
 public void rememberMeIsUncheck() {
  loginPage.assertRememberMeIsUncheck();
 }

 @Then("^Password is crossed$")
 public void passwordIsCrossed() {
  loginPage.assertPasswordIsCrossed();
 }

 @And("^User clicks on Eye button$")
 public void userClicksOnEyeButton() {
  loginPage.clickEyeButton();
 }

 @Then("^Password is displayed$")
 public void passwordIsDisplayed() {
  loginPage.assertPasswordIsDisplayed();
 }

 @And("^User waits until Log out button is displayed$")
 public void userWaitsUntilLogOutButtonIsDisplayed() {
  loginPage.waitUntilLogoutButtonIsDisplayed();
 }

 @When("^User logins with \"([^\"]*)\" and \"([^\"]*)\" from example$")
 public void userLoginsWithEmailAndPasswordFromExample(String email, String password) {
  loginPage.enterEmailFromExample(email);
  loginPage.enterPasswordFromExample(password);
  loginPage.clickLoginButton();
 }

 @When("^User clicks on Forgot Password hyperlink$")
 public void userClicksOnForgotPasswordHyperlink() {
  loginPage.clickForgotPasswordHyperlink();
 }

 @And("^User waits until Reset Your Password page is displayed$")
 public void userWaitsUntilResetYourPasswordPageIsDisplayed() {
  loginPage.waitUntilResetYourPasswordPageIsDisplayed();
 }

 @When("^User clicks on Sign Up Here hyperlink$")
 public void userClicksOnSignUpHereHyperlink() {
  loginPage.clickSignUpHereHyperlink();
 }

 @And("^User waits until Sign Up page is displayed$")
 public void userWaitsUntilSignUpPageIsDisplayed() {
  loginPage.waitUntilSignUpPageIsDisplayed();
 }

 @And("^User waits until 'Email or password is invalid' error is displayed$")
 public void userWaitsUntilEmailOrPasswordIsInvalidErrorIsDisplayed() {
  loginPage.waitUntilEmailOrPasswodIsInvalidErrorIsDisplayed();
 }

 @When("^User logins with \"([^\"]*)\" and \"([^\"]*)\"$")
 public void userLoginsWithAnd(String validEmail, String validPassword) {
  loginPage.login(validEmail, validPassword);
 }

 @When("^User enters \"([^\"]*)\"$")
 public void userEnters(String validPassword) {
 loginPage.enterValidPassword(validPassword);
 }

 @When("^User enters only \"([^\"]*)\"$")
 public void userEntersOnly(String validEmail) {
  loginPage.enterValidEmail(validEmail);
 }

 @Then("^The Login Page \"([^\"]*)\" is displayed correctly$")
 public void theLoginPageIsDisplayedCorrectly(String title) {
 loginPage.assertTheLoginPageTitleIsDisplayedCorrectly(title);
 }

 @Then("^\"([^\"]*)\" is displayed correctly below email field$")
 public void isDisplayedCorrectlyBelowEmailField(String requiredError) {
  loginPage.assertRequiredErrorDisplayedCorrectlyBelowEmailField(requiredError);
 }

 @Then("^\"([^\"]*)\" is displayed correctly below password field$")
 public void isDisplayedCorrectlyBelowPasswordField(String requiredError) {
  loginPage.assertRequiredErrorDisplayedCorrectlyBelowPasswordField(requiredError);
 }

 @Then("^The Reset Your Password Page \"([^\"]*)\" is displayed correctly$")
 public void theResetYourPasswordPageIsDisplayedCorrectly(String title) {
  loginPage.assertResetYourPasswordPageTitleIsDisplayedCorrectly(title);
 }

 @Then("^The Sign Up page \"([^\"]*)\" is displayed correctly$")
 public void theSignUpPageIsDisplayedCorrectly(String title) {
  loginPage.assertSignUpPageTitleIsDisplayedCorrectly(title);
 }

 @When("^User logins with \"([^\"]*)\" and \"([^\"]*)\" and checks Remember Me$")
 public void userLoginsWithAndAndChecksRememberMe(String validEmail, String validPassword) {
  loginPage.loginWithRememberMe(validEmail, validPassword);
 }

 @Then("^The email information \"([^\"]*)\" at attribute \"([^\"]*)\" is saved correctly$")
 public void theEmailInformationAtAttributeIsSavedCorrectly(String validEmail, String value) {
  loginPage.assertEmailIsSavedCorrectly(validEmail, value);
 }

 @And("^The password information \"([^\"]*)\" at attribute \"([^\"]*)\" is saved correctly$")
 public void thePasswordInformationAtAttributeIsSavedCorrectly(String validPassword, String value) {
  loginPage.assertPasswordIsSavedCorrectly(validPassword, value);
 }

 @Then("^Email or password is invalid \"([^\"]*)\" is displayed correctly$")
 public void emailOrPasswordIsInvalidIsDisplayedCorrectly(String error) {
  loginPage.assertEmailOrPasswordIsInvalidErrorIsDisplayedCorrectly(error);
 }

 @When("^User logins with \"([^\"]*)\" and the \"([^\"]*)\"$")
 public void userLoginsWithAndThe(String incorrectEmail, String validPassword) {
  loginPage.loginWithIncorrectEmail(incorrectEmail, validPassword);
 }

 @When("^User logins with the \"([^\"]*)\" and \"([^\"]*)\"$")
 public void userLoginsWithTheAnd(String validEmail, String incorrectPassword) {
  loginPage.loginWithIncorrectPassword(validEmail, incorrectPassword);
 }

 @When("^User logins with the \"([^\"]*)\" and the \"([^\"]*)\"$")
 public void userLoginsWithTheAndThe(String incorrectEmail, String incorrectPassword) {
  loginPage.loginWithIncorrectEmailAndPassword(incorrectEmail, incorrectPassword);
 }

}
