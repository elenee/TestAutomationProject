package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By signupNameField = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailField = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");

    private By loginEmailField = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordField = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loginHeader = By.xpath("//h2[text()='Login to your account']");

    private By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By logoutButton = By.xpath("//a[contains(@href, '/logout')]");

    public LoginPage enterSignupName(String name) {
        type(signupNameField, name);
        return this;
    }

    public LoginPage enterSignupEmail(String email) {
        type(signupEmailField, email);
        return this;
    }

    public SignupPage clickSignupButton() {
        click(signupButton);
        return new SignupPage(driver);
    }

    public LoginPage enterLoginEmail(String email) {
        type(loginEmailField, email);
        return this;
    }

    public LoginPage enterLoginPassword(String password) {
        type(loginPasswordField, password);
        return this;
    }

    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage(driver);
    }

    public boolean isLoginHeaderVisible() {
        return isDisplayed(loginHeader);
    }

    public boolean isLoginPageVisible() {
        return isDisplayed(loginButton);
    }

    public boolean isLoggedInAsVisible() {
        return isDisplayed(loggedInAsText);
    }

    public HomePage clickLogout() {
        click(logoutButton);
        return new HomePage(driver);
    }
}