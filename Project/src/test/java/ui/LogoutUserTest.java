package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class LogoutUserTest extends TestBase {
    @Test
    public void LogoutUserTest(){
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login page is not visible");

        loginPage.enterEmail("ketevansamukashvili@gmail.com")
                .enterPassword("BatmanBatman")
                .clickLogin();

        Assert.assertTrue(loginPage.isLoggedInAsVisible(), "User is not logged in");

        loginPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginHeaderVisible(), "User was not redirected to login page");

    }
}
