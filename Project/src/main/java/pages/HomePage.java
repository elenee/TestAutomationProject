package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By contactUsButton = By.xpath("//a[text()=' Contact us']");

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }
    public HomePage clickSignupLogin() {
        click(signupLoginButton);
        return this;
    }
    public HomePage clickContactUs() {
        click(contactUsButton);
        return this;
    }
}
