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
    private By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By testCasesButton = By.cssSelector("a[href='/test_cases']");

    private final By subscriptionHeader = By.xpath("//h2[normalize-space(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'))='SUBSCRIPTION']");
    private final By subscribeEmailInput = By.id("susbscribe_email");
    private final By subscribeArrowButton = By.id("subscribe");
    private final By subscribeSuccessAlert = By.xpath("//div[contains(@class,'alert-success') and contains(.,'You have been successfully subscribed!')]");


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
    public ProductPage clickFirstProductView() {
        click(firstProductViewButton);
        return new ProductPage(driver);
    }
    public HomePage clickTestCases() {
        click(testCasesButton);
        return this;
    }

    public void scrollToFooterSubscription() {
        scrollIntoView(subscriptionHeader);
    }

    public boolean isSubscriptionHeaderVisible() {
        return isDisplayed(subscriptionHeader);
    }

    public void subscribeWithEmail(String email) {
        type(subscribeEmailInput, email);
        click(subscribeArrowButton);
    }

    public boolean isSubscriptionSuccessVisible() {
        return isDisplayed(subscribeSuccessAlert);
    }

}
