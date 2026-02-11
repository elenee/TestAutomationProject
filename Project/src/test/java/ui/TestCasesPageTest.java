package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;
import utils.DriverFactory;

@Epic("UI Tests")
public class TestCasesPageTest extends TestBase {
    @Test
    @Description("This test verifies that clicking 'Test Cases' from Home Page navigates user to Test Cases page.")
    public void verifyTestCasesPageTest() {
        Allure.step("Open homepage", () ->
        DriverFactory.getDriver().get("http://automationexercise.com"));

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        TestCasesPage testCasesPage = new TestCasesPage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible", () ->
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible"));

        homePage.clickTestCases();

        Allure.step("Verify user is navigated to Test Cases page", () ->
        Assert.assertTrue(testCasesPage.isTestCasesHeaderVisible(), "User is not navigated to test cases page successfully"));
    }
}
