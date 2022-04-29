package Steps.SignUp;

import Pages.SignUpPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSteps {
    SignUpPage signUpPage;

    @Given("^Navigate to Sign Up page$")
    public void navigateToSignUpPage() {
        signUpPage.navigateToSignUpPage();
    }

    @When("^Generates randomly Firstname, Lastname with email \"([^\"]*)\" and \"([^\"]*)\"$")
    public void generatesRandomlyFirstnameLastnameWithEmailAnd(String domain, String password) {
        signUpPage.generateValidDatas(domain, password);
    }

    @And("^User enters valid data on each field$")
    public void userEntersValidDataOnEachField() {
        signUpPage.enterValidDatasOnEachField();
    }

    @And("^User clicks on Sign Up button$")
    public void userClicksOnSignUpButton() {
        signUpPage.clickSignUpButton();
    }

    @And("^The Verify Email page is displayed with correct \"([^\"]*)\"$")
    public void theVerifyEmailPageIsDisplayedWithCorrect(String title) {
        signUpPage.waitUntilVerifyEmailPageIsDisplayed();
        signUpPage.assertVerifyEmailPageTitleIsDisplayedCorrectly(title);
    }

    @And("^Navigate to email generating website by \"([^\"]*)\"$")
    public void navigateToEmailGeneratingWebsiteBy(String script) {
        signUpPage.navigateToEmailGeneratingWebsite(script);
    }

    @And("^Enter verification code from the generating email website$")
    public void entersVerificationCodeFromTheGeneratingEmailWebsite() throws InterruptedException {
        signUpPage.enterVerificationCodeFromTheGeneratingEmailWebsite();
    }

    @And("^User clicks on Confirm button$")
    public void userClicksOnConfirmButton() throws InterruptedException {
        signUpPage.switchToIResourceTab();
        signUpPage.clickConfirmButton();
    }

    @And("^Account information is saved to file InternalPersonaAccounts\\.csv$")
    public void accountInformationIsSavedToFileInternalPersonaAccountsCsv() {
        signUpPage.saveData();
    }

    @Then("^The Login page \"([^\"]*)\" is displayed correctly$")
    public void theLoginPageIsDisplayedCorrectly(String titlelogin) {
        signUpPage.assertLoginPageTitle(titlelogin);
    }
}
