package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) { super(driver); }
    private By accountInfoHeader = By.xpath("//b[text()='Enter Account Information']");
    private By titleMr = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By dobDay = By.id("days");
    private By dobMonth = By.id("months");
    private By dobYear = By.id("years");
    private By newsletter = By.id("newsletter");
    private By specialOffers = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileField = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    private By successMessage = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");
    public boolean isAccountCreatedVisible() {
        return isDisplayed(successMessage);
    }
    public boolean isEnterAccountInfoVisible() {
        return isDisplayed(accountInfoHeader);
    }

    public SignupPage fillAccountDetails(String password, String day, String month, String year) {
        click(titleMr);
        type(passwordField, password);
        selectDropdownByValue(dobDay, day);
        selectDropdownByValue(dobMonth, month);
        selectDropdownByValue(dobYear, year);
        click(newsletter);
        click(specialOffers);
        return this;
    }
    public SignupPage fillAddressDetails(String fName, String lName, String company, String addr1, String addr2,
                                         String country, String state, String city, String zip, String mobile) {
        type(firstNameField, fName);
        type(lastNameField, lName);
        type(companyField, company);
        type(address1Field, addr1);
        type(address2Field, addr2);
        selectDropdownByText(countryDropdown, country);
        type(stateField, state);
        type(cityField, city);
        type(zipcodeField, zip);
        type(mobileField, mobile);
        return this;
    }

    public SignupPage clickCreateAccount() {
        click(createAccountBtn);
        return this;
    }

    public HomePage clickContinue() {
        click(continueButton);
        return new HomePage(driver);
    }
}