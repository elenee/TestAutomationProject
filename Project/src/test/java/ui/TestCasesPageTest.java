package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;
import utils.DriverFactory;

public class TestCasesPageTest extends TestBase {
    @Test
    public void verifyTestCasesPageTest() {
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        TestCasesPage testCasesPage = new TestCasesPage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.clickTestCases();

        Assert.assertTrue(testCasesPage.isTestCasesHeaderVisible(), "User is not navigated to test cases page successfully");
    }
}
