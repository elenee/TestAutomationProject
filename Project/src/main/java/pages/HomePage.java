package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By loggedInStatus = By.xpath("//a[contains(text(), 'Logged in as')]");
    private By deleteAccountBtn = By.cssSelector("a[href='/delete_account']");
    private By accountDeletedMsg = By.xpath("//b[text()='Account Deleted!']");
    private By continueBtn = By.cssSelector("a[data-qa='continue-button']");
    private By contactUsButton = By.xpath("//a[text()=' Contact us']");

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }
    public LoginPage clickSignupLogin() {
        click(signupLoginButton);
        return new LoginPage(driver);
    }
    public void clickDeleteAccount() {
        click(deleteAccountBtn);
    }
    public boolean isAccountDeletedVisible() {
        return isDisplayed(accountDeletedMsg);
    }
    public void clickContinueAfterDelete() {
        click(continueBtn);
    }
    public boolean isLoggedInAs(String username) {
        return getText(loggedInStatus).contains(username);
    }
    public HomePage clickContactUs() {
        click(contactUsButton);
        return this;
    }
}
