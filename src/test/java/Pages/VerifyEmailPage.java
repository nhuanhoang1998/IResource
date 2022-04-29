package Pages;

import Elements.EmailGeneratingPage_Elements;
import Elements.SignUpPage_Elements;
import Elements.VerifyEmailPage_Elements;
import GenerateData.GenerateData;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyEmailPage extends PageObject {
    GenerateData generateData = new GenerateData();
    SignUpPage_Elements signUpPage_elements = new SignUpPage_Elements();
    VerifyEmailPage_Elements verifyEmailPage_elements = new VerifyEmailPage_Elements();
    EmailGeneratingPage_Elements emailGeneratingPage_elements = new EmailGeneratingPage_Elements();

    WebDriver driver;
    LoginPage loginPage;
    SignUpPage signUpPage;

    public VerifyEmailPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getVerifyEmailPageTitle() {
        return driver.findElement(verifyEmailPage_elements.verifyEmailPageTitle).getText();
    }
    public String expectVerifyEmailPageTitle(String title) {
        return title;
    }
    public void waitUntilVerifyEmailPageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyEmailPage_elements.verifyEmailPageTitle));
    }
    public void assertVerifyEmailPageTitleIsDisplayedCorrectly(String title) {
        Assert.assertEquals(getVerifyEmailPageTitle(), expectVerifyEmailPageTitle(title));
    }
}
