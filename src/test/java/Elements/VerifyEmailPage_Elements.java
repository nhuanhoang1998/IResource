package Elements;

import org.openqa.selenium.By;

public class VerifyEmailPage_Elements {
    public By verifyEmailPageTitle = By.xpath("//h2[contains(text(),'Verify Email')]");

    public By verifyCodeField = By.xpath("/html/body/div/div/div[1]/div/div[2]/div[2]/div/form/div[2]/input");

    public By confirmButton = By.xpath("/html/body/div/div/div[1]/div/div[2]/div[2]/div/form/button");

    public By resendEmailButton = By.className("verify-email-form-resend-btn");

    public By notification = By.className("Toastify__toast-body");

}
