package ui;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.DriverFactory;

import java.io.File;

public class ContactUsTest extends TestBase {

    @Test
    public void contactUsFormTest() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible");

        homePage.clickContactUs();

        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible");

        String filePath = new File("src/test/resources/testfile.txt").getAbsolutePath();

        contactUsPage
                .enterName("ravici")
                .enterEmail("ravici@mail.com")
                .enterSubject("Automation Test")
                .enterMessage("This is a test message")
                .uploadFile(filePath)
                .clickSubmitAndAcceptAlert();

        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message not displayed");

        contactUsPage.clickHome();

        Assert.assertTrue(homePage.isHomePageVisible(), "Did not land on Home page");
    }
}