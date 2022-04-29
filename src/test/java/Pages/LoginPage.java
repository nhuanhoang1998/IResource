package Pages;

import DynamicData.DynamicDataTest;
import Elements.LoginPage_Elements;
import Elements.ResetYourPassword_Elements;
import Elements.SignUpPage_Elements;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://iresource.smartdev.vn")

public class LoginPage extends PageObject {
    DynamicDataTest dynamicDataTest = new DynamicDataTest();
    LoginPage_Elements loginPage_elements = new LoginPage_Elements();
    ResetYourPassword_Elements resetYourPassword_elements = new ResetYourPassword_Elements();
    SignUpPage_Elements signUpPage_elements = new SignUpPage_Elements();
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //REFRESH
    //làm mới trang
    public void refresh() {
        driver.navigate().refresh();
    }

    //ENTER DATA
    //enter incorrectly
    public void enterIncorrectEmail(String incorrectEmail) {
        driver.findElement(loginPage_elements.email).sendKeys(incorrectEmail);
    }
    public void enterIncorrectPassword(String incorrectPassword) {
        driver.findElement(loginPage_elements.password).sendKeys(incorrectPassword);
    }
    public void enterValidEmail(String validEmail) {
        driver.findElement(loginPage_elements.email).sendKeys(validEmail);
    }
    public void enterValidPassword(String validPassword) {
        driver.findElement(loginPage_elements.password).sendKeys(validPassword);
    }

    //example scenario outline
    public void enterEmailFromExample(String email) {
        driver.findElement(loginPage_elements.email).sendKeys(email);
    }

    public void enterPasswordFromExample(String password) {
        driver.findElement(loginPage_elements.password).sendKeys(password);
    }

    //CLICK
    public void clickEyeButton() {
        driver.findElement(loginPage_elements.eye).click();
    }
    public void clickRememberMe() {
        driver.findElement(loginPage_elements.rememberMe).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginPage_elements.loginButton).click();
    }
    public void clickLogoutButton() {
        driver.findElement(loginPage_elements.logoutButton).click();
    }
    public void clickForgotPasswordHyperlink() {
        driver.findElement(loginPage_elements.forgotPasswordHyperlink).click();
    }
    public void clickSignUpHereHyperlink() {
        driver.findElement(loginPage_elements.signUpHereHyperlink).click();
    }

    //GET TEXT
    //get title
    public String getLoginPageTitle() {
        return driver.findElement(loginPage_elements.loginPageTitle).getText();
    }

    //get data
    public String getSavedEmail(String value) {
        return driver.findElement(loginPage_elements.email).getAttribute(value);
    }
    public String getSavedPassword(String value) {
        return driver.findElement(loginPage_elements.password).getAttribute(value);
    }
    //get error
    public String getEmailFieldError() {
        return driver.findElement(loginPage_elements.emailFieldError).getText();
    }
    public String getPasswordFieldError() {
        return driver.findElement(loginPage_elements.passwordFieldError).getText();
    }
    public String getErrorOrPasswordIsInvalidError() {
        return driver.findElement(loginPage_elements.emailOrPasswordIsInvalidError).getText();
    }
    public String getResetYourPasswordPageTitle() {
        return driver.findElement(resetYourPassword_elements.resetYourPasswordPageTitle).getText();
    }
    public String getSignUpPageTitle() {
        return driver.findElement(signUpPage_elements.signUpPageTitle).getText();
    }


    //EXPECT
    //expect title
    public String expectLoginPageTitle(String title) {
        return title;
    }
    public String expectSignUpPageTitle(String title) {
        return title;
    }

    //expect data
    public String expectSavedEmail(String validEmail) {
        return validEmail;
    }
    public String expectSavedPassword(String validPassword) {
        return validPassword;
    }

    //expect error
    public String expectRequiredError(String requiredError) {
        return requiredError;
    }
    public String expectEmailOrPasswordIsInvalidError(String error) {
        return error;
    }
    public String expectResetYourPasswordPageTitle(String title) {
        return title;
    }

    //ASSERT
    //yes - no
    public boolean assertDisplayedPassword() {
        return driver.findElement(loginPage_elements.password).isDisplayed();
    }
    public boolean assertDefaultRememberMe() {
        driver.findElement(loginPage_elements.rememberMe).isSelected();
        return false;
    }
    public void assertRememberMeIsUncheck() {
        Assert.assertFalse(assertDefaultRememberMe());
    }
    public void assertPasswordIsCrossed() {
        Assert.assertTrue(assertDisplayedPassword()); //not displayed
    }
    public void assertPasswordIsDisplayed() {
        Assert.assertTrue(assertDisplayedPassword()); //displayed
    }

    //get - expect
    public void assertTheLoginPageTitleIsDisplayedCorrectly(String title) {
        Assert.assertEquals(getLoginPageTitle(),expectLoginPageTitle(title));
    }
    public void assertEmailOrPasswordIsInvalidErrorIsDisplayedCorrectly(String error) {
        Assert.assertEquals(getErrorOrPasswordIsInvalidError(), expectEmailOrPasswordIsInvalidError(error));
    }
    public void assertEmailIsSavedCorrectly(String validEmail, String value) {
        Assert.assertEquals(getSavedEmail(value), expectSavedEmail(validEmail));
    }
    public void assertPasswordIsSavedCorrectly(String validPassword, String value) {
        Assert.assertEquals(getSavedPassword(value), expectSavedPassword(validPassword));
    }
    public void assertRequiredErrorDisplayedCorrectlyBelowEmailField(String requiredError) {
        Assert.assertEquals(getEmailFieldError(), expectRequiredError(requiredError));
    }
    public void assertRequiredErrorDisplayedCorrectlyBelowPasswordField(String requiredError) {
        Assert.assertEquals(getPasswordFieldError(), expectRequiredError(requiredError));
    }
    public void assertResetYourPasswordPageTitleIsDisplayedCorrectly(String title) {
        Assert.assertEquals(getResetYourPasswordPageTitle(), expectResetYourPasswordPageTitle(title));
    }
    public void assertSignUpPageTitleIsDisplayedCorrectly(String title) {
        Assert.assertEquals(getSignUpPageTitle(), expectSignUpPageTitle(title));
    }

    //WAIT
    public void waitUntilLogoutButtonIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage_elements.logoutButton));
    }
    public void waitUntilResetYourPasswordPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetYourPassword_elements.resetYourPasswordPageTitle));
    }
    public void waitUntilSignUpPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPage_elements.signUpPageTitle));
    }
    public void waitUntilEmailOrPasswodIsInvalidErrorIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage_elements.emailOrPasswordIsInvalidError));
    }

    //GROUP LOGIN CODES
    //enter email, password rồi click nút login
    public void login(String validEmail, String validPassword) {
        enterValidEmail(validEmail);
        enterValidPassword(validPassword);
        clickLoginButton();
    }
    public void loginWithRememberMe(String validEmail, String validPassword) {
        enterValidEmail(validEmail);
        enterValidPassword(validPassword);
        clickRememberMe();
        clickLoginButton();
    }
    //login with incorrect infor
    public void loginWithIncorrectEmail(String incorrectEmail, String validPassword) {
        enterIncorrectEmail(incorrectEmail);
        enterValidPassword(validPassword);
        clickLoginButton();
    }
    public void loginWithIncorrectPassword(String validEmail, String incorrectPassword) {
        enterValidEmail(validEmail);
        enterIncorrectPassword(incorrectPassword);
        clickLoginButton();
    }
    public void loginWithIncorrectEmailAndPassword(String incorrectEmail, String incorrectPassword) {
        enterIncorrectEmail(incorrectEmail);
        enterIncorrectPassword(incorrectPassword);
        clickLoginButton();
    }
}