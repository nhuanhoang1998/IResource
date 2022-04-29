package Pages;

import Elements.ResetYourPassword_Elements;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class ResetYourPasswordPage extends PageObject{

    ResetYourPassword_Elements resetYourPassword_elements = new ResetYourPassword_Elements();
    WebDriver driver;

    public String getResetYourPasswordPageTitle() {
        return driver.findElement(resetYourPassword_elements.resetYourPasswordPageTitle).getText();
    }
    public String expectResetYourPasswordPageTitle(String title) {
        return title;
    }

}
