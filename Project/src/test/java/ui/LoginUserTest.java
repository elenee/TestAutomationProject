package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginUserTest extends TestBase {

    @Test
    public void testLoginUserWithCorrectCredentials() {
        String email = "elene@gmail.com";
        String password = "Pass123!";
        String username = "elene";

        driver.get("https://automationexercise.com");
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible!");

        LoginPage loginPage = homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "'Login to your account' is not visible!");

        loginPage.enterLoginEmail(email)
                .enterLoginPassword(password)
                .clickLogin();

        Assert.assertTrue(homePage.isLoggedInAs(username), "Logged in status not visible!");
        homePage.clickDeleteAccount();
        Assert.assertTrue(homePage.isAccountDeletedVisible(), "Account Deleted message not found!");
    }
}