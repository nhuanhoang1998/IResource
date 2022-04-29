package Pages;

import Elements.EmailGeneratingPage_Elements;
import Elements.LoginPage_Elements;
import Elements.SignUpPage_Elements;
import Elements.VerifyEmailPage_Elements;
import GenerateData.GenerateData;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUpPage extends PageObject {
    GenerateData generateData = new GenerateData();
    LoginPage_Elements loginPage_elements = new LoginPage_Elements();
    SignUpPage_Elements signUpPage_elements = new SignUpPage_Elements();
    VerifyEmailPage_Elements verifyEmailPage_elements = new VerifyEmailPage_Elements();
    EmailGeneratingPage_Elements emailGeneratingPage_elements = new EmailGeneratingPage_Elements();

    WebDriver driver;
    LoginPage loginPage;
    String code;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //REFRESH PAGE
    public void refresh() {
        driver.navigate().refresh();
    }

    //NAVIGATE
    public void navigateToSignUpPage() {
        loginPage.open();
        loginPage.clickSignUpHereHyperlink();
        loginPage.waitUntilSignUpPageIsDisplayed();
    }
    public void navigateToEmailGeneratingWebsite(String script) {
        ((JavascriptExecutor)driver).executeScript(script);
    }

    //TABS
    public void switchToEmailGeneratingTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void switchToIResourceTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }

    //GENERATE DATA
    public void generateValidDatas(String domain, String password) {
        generateData.generateValidDatas(domain, password);
    }

    //GET
    public String getVerifyEmailPageTitle() {
        return driver.findElement(verifyEmailPage_elements.verifyEmailPageTitle).getText();
    }
    public String getLoginPageTitle() {
        return driver.findElement(loginPage_elements.loginPageTitle).getText();
    }

    //EXPECT
    public String expectVerifyEmailPageTitle(String title) {
        return title;
    }
    public String expectLoginPageTitle(String titlelogin) {
        return titlelogin;
    }

    //ENTER DATA
    public void enterFirstName() {
        driver.findElement(signUpPage_elements.firstName).sendKeys(generateData.getFirstName());
    }
    public void enterLastName() {
        driver.findElement(signUpPage_elements.lastName).sendKeys(generateData.getLastName());
    }
    public void enterEmail() {
        driver.findElement(signUpPage_elements.email).sendKeys(generateData.getEmailwithDomain());
    }
    public void enterPassword() {
        driver.findElement(signUpPage_elements.password).sendKeys(generateData.getPassword());
    }
    public void confirmPassword() {
        driver.findElement(signUpPage_elements.confirmPassword).sendKeys(generateData.getPassword());
    }
    public void enterVerificationCode(String code) {
        driver.findElement(verifyEmailPage_elements.verifyCodeField).sendKeys(code);
    }

    //CLICK
    public void clickSignUpButton() {
        driver.findElement(signUpPage_elements.signUpButton).click();
    }
    public void openMail() {
        driver.findElement(emailGeneratingPage_elements.emailTitle).click();
    }
    public void clickGoButton() {
        driver.findElement(emailGeneratingPage_elements.goButton).click();
    }
    public void clickConfirmButton() {
        try {
            driver.findElement(verifyEmailPage_elements.confirmButton).click();
        } catch (NoSuchElementException e) {
            System.out.println();
        }
    }

    //ASSERT
    public void assertVerifyEmailPageTitleIsDisplayedCorrectly(String title) {
        Assert.assertEquals(getVerifyEmailPageTitle(), expectVerifyEmailPageTitle(title));
    }
    public void assertLoginPageTitle(String titlelogin) {
        waitUntilLoginPageIsDisplayed();
        Assert.assertEquals(getLoginPageTitle(), expectLoginPageTitle(titlelogin));
    }

    //WAIT
    public void waitUntilVerifyEmailPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyEmailPage_elements.verifyEmailPageTitle));
    }
    public void waitUntilLoginPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage_elements.loginPageTitle));
    }
    public void enterEmailForGeneratingMailbox() {
        driver.findElement(emailGeneratingPage_elements.enterMailField).sendKeys(generateData.getEmailbodypart());
    }
    public void waitUntilFullMailAddressPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailGeneratingPage_elements.fullMailAddress));
    }
    public void refreshEmailReceived() throws InterruptedException {
        Thread.sleep(5000);
        refresh();
    }

    //GROUP CODES
    public void enterValidDatasOnEachField() {
        enterFirstName();
        enterLastName();
        enterEmail();
        enterPassword();
        confirmPassword();
    }
    public String getCodeFromEmailBodyText() {
        switchToEmailGeneratingTab();
        String text = driver.findElement(emailGeneratingPage_elements.emailBody).getText();
        String[] array = text.split(" ");
        System.out.println(Arrays.toString(array));
        return code = array[11];
    }
    public void enterVerificationCodeFromTheGeneratingEmailWebsite() throws InterruptedException {
        switchToEmailGeneratingTab();
        enterEmailForGeneratingMailbox();
        clickGoButton();
        waitUntilFullMailAddressPageIsDisplayed();
        refreshEmailReceived();
        openMail();
        code = getCodeFromEmailBodyText();
        switchToIResourceTab();
        enterVerificationCode(code);
    }
    public void saveData() {
        generateData.saveData();
    }
}
