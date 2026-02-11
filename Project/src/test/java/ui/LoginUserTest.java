package ui;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static io.qameta.allure.Allure.step;

@Epic("UI tests")
@Feature("User Authentication")
public class LoginUserTest extends TestBase {

    @Test()
    @Description("Validates that a registered user can successfully log in and delete their account.")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUserWithCorrectCredentials() {
        String email = "elenikoo@gmail.com";
        String password = "Pass123!";
        String username = "elene";

        Allure.step("Navigate to home page");
        driver.get("https://automationexercise.com");
        HomePage homePage = new HomePage(driver);

        Allure.step("Verify home page is visible");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible!");

        Allure.step("Click Signup/Login button");
        LoginPage loginPage = homePage.clickSignupLogin();

        Allure.step("Verify login page is visible");
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page not visible");

        Allure.step("Enter login credentials");
        loginPage.enterLoginEmail(email)
                .enterLoginPassword(password)
                .clickLogin();

        Allure.step("Verify user is logged in as: " + username);
        Assert.assertTrue(homePage.isLoggedInAs(username), "Logged in status not visible!");
        Allure.step("Delete account");
        homePage.clickDeleteAccount();
        Allure.step("Verify account deleted message");
        Assert.assertTrue(homePage.isAccountDeletedVisible(), "Account Deleted message not found!");
    }
}