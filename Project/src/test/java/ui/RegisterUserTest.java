package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

public class RegisterUserTest extends TestBase {
    @Test
    public void testRegisterUser() {
        DriverFactory.getDriver().get("https://automationexercise.com");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        homePage.clickSignupLogin();
        LoginPage loginPage = new LoginPage(driver);

        String username = "elene";
        String email = "elene@gmail.com";
        loginPage.enterSignupName(username);
        loginPage.enterSignupEmail(email);

        SignupPage signupPage = loginPage.clickSignupButton();
        Assert.assertTrue(signupPage.isEnterAccountInfoVisible());
        signupPage.fillAccountDetails("Pass123!", "15", "5", "1990");

        signupPage.fillAddressDetails(
                "John", "Doe", "MyCompany",
                "123 Street", "Apt 4", "United States",
                "CA", "LA", "90001", "5551234"
        );

        signupPage.clickCreateAccount();

        Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Success message not found!");
        signupPage.clickContinue();
        driver.navigate().refresh();

        Assert.assertTrue(homePage.isLoggedInAs(username), "Username not displayed in header");

        homePage.clickDeleteAccount();

        Assert.assertTrue(homePage.isAccountDeletedVisible(), "Account Deleted message not found!");
        homePage.clickContinueAfterDelete();
    }
}