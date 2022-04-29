//package Pages;
//
//import Elements.EmailGeneratingPage_Elements;
//import GenerateData.GenerateData;
//import net.serenitybdd.core.pages.PageObject;
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.Arrays;
//
//public class EmailGeneratingPage extends PageObject{
//    GenerateData generateData = new GenerateData();
//    EmailGeneratingPage_Elements emailGeneratingPage_elements = new EmailGeneratingPage_Elements();
//    WebDriver driver;
//    SignUpPage signUpPage;
//
//    public EmailGeneratingPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    //REFRESH PAGE
//    public void refresh() {
//        driver.navigate().refresh();
//    }
//
//    //CLICK
//    public void clickGoButton() {
//        driver.findElement(emailGeneratingPage_elements.goButton).click();
//    }
//
//
//    //ASSERT
//    public boolean assertEmailReceived() {
//        Assert.assertTrue(driver.findElement(emailGeneratingPage_elements.emailBody).isDisplayed());
//        return true;
//    }
//
//    public void enterEmailForGeneratingMailbox() {
//        driver.findElement(emailGeneratingPage_elements.enterMailField).sendKeys(generateData.getEmailbodypart());
//    }
//
//    public String getCodeFromEmailBodyText() {
//        signUpPage.switchToEmailGeneratingTab();
//        String code;
//        String text = driver.findElement(emailGeneratingPage_elements.emailBody).getText();
//        String[] array = text.split(" ");
//        System.out.println(Arrays.toString(array));
//        return code = array[1];
//    }
//    public void waitUntilFullMailAddressPageIsDisplayed() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailGeneratingPage_elements.fullMailAddress));
//    }
//
//}
