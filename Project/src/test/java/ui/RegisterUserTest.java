package ui;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

@Epic("UI tests")
@Feature("User Registration")
public class RegisterUserTest extends TestBase {
    @Test
    @Description("Verifies user can register, is logged in, and account can be deleted")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegisterUser() {

        Allure.step("Navigate to home page");
        DriverFactory.getDriver().get("https://automationexercise.com");
        HomePage homePage = new HomePage(driver);

        Allure.step("Verify home page is visible");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible");

        Allure.step("Click Signup/Login button");
        homePage.clickSignupLogin();
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Verify login page is visible");
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page not visible");

        String username = "elene";
        String email = "elen" + System.currentTimeMillis() + "@gmail.com";

        Allure.step("Enter signup credentials");
        loginPage.enterSignupName(username);
        loginPage.enterSignupEmail(email);

        Allure.step("Click signup button and verify account info page");
        SignupPage signupPage = loginPage.clickSignupButton();
        Assert.assertTrue(signupPage.isEnterAccountInfoVisible());

        Allure.step("Fill account and address details");
        signupPage.fillAccountDetails("Pass123!", "15", "5", "1990");
        signupPage.fillAddressDetails(
                "John", "Doe", "MyCompany",
                "123 Street", "Apt 4", "United States",
                "CA", "LA", "90001", "5551234"
        );

        Allure.step("Click create account");
        signupPage.clickCreateAccount();

        Allure.step("Verify account created message");
        Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Success message not found!");

        Allure.step("Click continue after account creation");
        homePage = signupPage.clickContinue();

        Allure.step("Verify user is logged in");
        Assert.assertTrue(homePage.isLoggedInAs(username), "Username not displayed in header");

        Allure.step("Delete account");
        homePage.clickDeleteAccount();

        Allure.step("Verify account deleted message");
        Assert.assertTrue(homePage.isAccountDeletedVisible(), "Account Deleted message not found!");

        Allure.step("Click continue after account deletion");
        homePage.clickContinueAfterDelete();
    }
}