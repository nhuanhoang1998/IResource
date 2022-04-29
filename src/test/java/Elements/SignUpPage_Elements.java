package Elements;

import org.openqa.selenium.By;

public class SignUpPage_Elements {
    public By firstName = By.name("firstname");

    public By lastName = By.name("lastname");

    public By email = By.name("email");

    public By password = By.name("password");

    public By confirmPassword = By.name("confirmPassword");

    public By signUpButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[6]/button[1]");

    public By notification = By.className("Toastify__toast-body");

    public By signUpPageTitle = By.className("signup-title");

}
