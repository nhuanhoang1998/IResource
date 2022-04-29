package Elements;

import org.openqa.selenium.By;

public class LoginPage_Elements {
    public By loginPageTitle = By.className("login-title");

    public By email = By.name("email");

    public By emailFieldError = By.xpath("/html/body/div/div/div[1]/div/div[2]/div/div[1]/form/div[2]/p");

    public By password = By.id("password");

    public By passwordFieldError = By.xpath("/html/body/div/div/div[1]/div/div[2]/div/div[1]/form/div[3]/p");

    public By eye = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/i[1]");

    public By rememberMe = By.className("remeber-mark");

    public By loginButton = By.className("login-form-submit-btn");

    public By logoutButton = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/nav[1]/div[2]/div[1]/i[1]");

    public By forgotPasswordHyperlink = By.className("forgot-password");

    public By signUpHereHyperlink = By.className("directional-signup-link");

    public By emailOrPasswordIsInvalidError = By.className("Toastify__toast-body");
}