package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private By getInTouchText = By.xpath("//h2[text()='Get In Touch']");
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageInput = By.id("message");
    private By uploadFileInput = By.name("upload_file");
    private By submitBtn = By.name("submit");
    private By successMessage = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    private By homeBtn = By.xpath("//a[@class='btn btn-success']");

    public boolean isGetInTouchVisible() {
        return isDisplayed(getInTouchText);
    }

    public ContactUsPage enterName(String name) {
        type(nameInput, name);
        return this;
    }

    public ContactUsPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    public ContactUsPage enterSubject(String subject) {
        type(subjectInput, subject);
        return this;
    }

    public ContactUsPage enterMessage(String message) {
        type(messageInput, message);
        return this;
    }

    public ContactUsPage uploadFile(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
        return this;
    }

    public ContactUsPage clickSubmitAndAcceptAlert() {
        click(submitBtn);
        driver.switchTo().alert().accept();
        return this;
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }

    public ContactUsPage clickHome() {
        click(homeBtn);
        return this;
    }
}
