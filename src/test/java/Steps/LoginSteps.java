package Steps;

import DynamicData.DynamicDataTest;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Assert;
import org.junit.runner.RunWith;

@UseTestDataFrom("Testdata/demodata.csv")
@RunWith(SerenityParameterizedRunner.class)

public class LoginSteps extends PageObject {
   LoginPage loginPage;
   DynamicDataTest dynamicDataTest = new DynamicDataTest();

 @Given("^User navigates to iresource website$")
 public void userNavigatesToIresourceWebsite() {
  loginPage.open();
 }

 @When("^User enters valid email$")
 public void userEntersValidEmail() {
  loginPage.enterEmail();
 }

 @And("^User enters valid password$")
 public void userEntersValidPassword() {
  loginPage.enterPassword();
 }

 @And("^User clicks on Login button$")
 public void userClicksOnLoginButton() {
  loginPage.clickLoginButton();
 }

 @Then("^User clicks on Logout button$")
 public void userClicksOnLogoutButton() {
  loginPage.waitUntilLogoutButtonAppear();
  loginPage.clickLogoutButton();
 }

 @Then("^User logins with valid email and password$")
 public void userLoginsWithValidEmailAndPassword() {
  loginPage.login();
 }

 @Then("^Required error is displayed below email field$")
 public void requiredErrorIsDisplayedBelowEmailField() {
  Assert.assertEquals(loginPage.getEmailFieldError(),loginPage.getRequiredEmailFieldError());
 }

 @Then("^Required error is displayed below password field$")
 public void requiredErrorIsDisplayedBelowPasswordField() {
  Assert.assertEquals(loginPage.getPasswordFieldError(), loginPage.getRequiredPasswordFieldError());
 }

 @Then("^Remember Me is uncheck$")
 public void rememberMeIsUncheck() {
  Assert.assertFalse(loginPage.defaultRememberMe());
 }

 @Then("^Password is crossed$")
 public void passwordIsCrossed() {
  Assert.assertTrue(loginPage.displayedPassword()); //not displayed
 }

 @And("^User clicks on Eye button$")
 public void userClicksOnEyeButton() {
  loginPage.clickEyeButton();
 }

 @Then("^Password is displayed$")
 public void passwordIsDisplayed() {
  Assert.assertTrue(loginPage.displayedPassword()); //displayed
 }

 @And("^User waits until Log out button is displayed$")
 public void userWaitsUntilLogOutButtonIsDisplayed() {
  loginPage.waitUntilLogoutButtonAppear();
 }

 @Then("^The Login page title is displayed correctly$")
 public void theLoginPageTitleIsDisplayedCorrecty() {
  Assert.assertEquals(loginPage.getLoginPageTitle(),loginPage.expectLoginPageTitle());
 }

 @When("^User logins with valid email and password from external data$")
 public void userLoginsWithValidEmailAndPasswordFromExternalData() {
  loginPage.enterDynamicEmail();
  loginPage.enterDynamicPassword();
  loginPage.clickLoginButton();
 }
}
