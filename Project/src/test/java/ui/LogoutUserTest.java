package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

@Epic("UI Tests")
public class LogoutUserTest extends TestBase {

    @Description("Verify that a user can login and logout successfully")
    @Test
    public void logoutUserTest() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible", () -> {
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        });

        Allure.step("Navigate to Login page", () -> {
            homePage.clickSignupLogin();
            Assert.assertTrue(loginPage.isLoginHeaderVisible(), "Login page is not visible");
        });

        Allure.step("Login with valid credentials", () -> {
            loginPage.enterLoginEmail("ketevansamukashvili@gmail.com")
                    .enterLoginPassword("BatmanBatman")
                    .clickLogin();
            Assert.assertTrue(loginPage.isLoggedInAsVisible(), "User is not logged in");
        });

        Allure.step("Logout and verify redirection to Login page", () -> {
            loginPage.clickLogout();
            Assert.assertTrue(loginPage.isLoginHeaderVisible(), "User was not redirected to login page");
        });
    }
}
