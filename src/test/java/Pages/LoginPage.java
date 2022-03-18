package Pages;

import DynamicData.DynamicDataTest;
import Elements.LoginPage_Elements;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@DefaultUrl("https://iresource.smartdev.vn")
@UseTestDataFrom("Testdata/demodata.csv")
@RunWith(SerenityParameterizedRunner.class)

public class LoginPage extends PageObject {
    DynamicDataTest dynamicDataTest = new DynamicDataTest();
    LoginPage_Elements loginPage_elements = new LoginPage_Elements();
    WebDriver driver;

    //variables
//    String email1 = "iresource_test1@yopmail.com";
//    String password1 = "Aa@123456";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //get tiêu đề login page
    public String getLoginPageTitle() {
        String LogIn;
        LogIn = driver.findElement(loginPage_elements.loginPageTitle).getText();
        return LogIn;
    }

    //tiêu đề page "Log In"
    public String expectLoginPageTitle() {
        return "Log In";
    }

    //làm mới trang
    public void refresh() {
        driver.navigate().refresh();
    }

    public void enterDynamicEmail() {
//        dynamicDataTest.test_getdatafromfile();
        System.out.println(dynamicDataTest.a + " " + dynamicDataTest.b);
        driver.findElement(loginPage_elements.email).sendKeys(dynamicDataTest.getDynamicEmail());
    }

    public void enterDynamicPassword() {
        System.out.println(dynamicDataTest.getDynamicPassword());
        driver.findElement(loginPage_elements.email).sendKeys(dynamicDataTest.getDynamicPassword());
    }

    //nhập email
    public void enterEmail() {
        driver.findElement(loginPage_elements.email).sendKeys("iresource_test1@yopmail.com");
    }

    //nhập password
    public void enterPassword() {
        driver.findElement(loginPage_elements.password).sendKeys("Aa@123456");
    }

    //check password có đc displayed hay không
    public boolean displayedPassword() {
        if(driver.findElement(loginPage_elements.password).isDisplayed()) {
            return true;
        } else return false;
    }

    //click eye button trong field password
    public void clickEyeButton() {
        driver.findElement(loginPage_elements.eye).click();
    }

    //check Remember Me mặc định có check hay không
    public boolean defaultRememberMe() {
        driver.findElement(loginPage_elements.rememberMe).isSelected();
        return false;
    }

    //click vào ô Remember Me
    public void clickRememberMe() {
        driver.findElement(loginPage_elements.rememberMe).click();
    }

    //click nút Login
    public void clickLoginButton() {
        driver.findElement(loginPage_elements.loginButton).click();
    }

    //click nút logout
    public void clickLogoutButton() {
        driver.findElement(loginPage_elements.logoutButton).click();
    }

    //chờ nút logout xuất hiện sau khi login thành công
    public void waitUntilLogoutButtonAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage_elements.logoutButton));
    }

    //get nội dung error ở Email field
    public String getEmailFieldError() {
        String error;
        error = driver.findElement(loginPage_elements.emailFieldError).getText();
        return error;
    }

    //error "Required!" ở Email field
    public String getRequiredEmailFieldError() {
        return "Required!";
    }

    //get nội dung error ở Password field
    public String getPasswordFieldError() {
        String error;
        error = driver.findElement(loginPage_elements.passwordFieldError).getText();
        return error;
    }

    //error Required! ở Password field
    public String getRequiredPasswordFieldError() {
        return "Required!";
    }

    //enter email, password rồi click nút login
    public void login() {
        enterEmail();
        enterPassword();
        clickLoginButton();
    }
}
