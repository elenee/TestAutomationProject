package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By loginHeader = By.xpath("//h2[text()='Login to your account']");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public boolean isLoginHeaderVisible() {
        return isDisplayed(loginHeader);
    }

    public LoginPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginButton);
        return this;
    }

    public boolean isLoggedInAsVisible() {
        return isDisplayed(loggedInAsText);
    }

    public LoginPage clickLogout() {
        click(logoutButton);
        return this;
    }

}
