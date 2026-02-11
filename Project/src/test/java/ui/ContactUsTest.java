package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.DriverFactory;

import java.io.File;

@Epic("UI Tests")
public class ContactUsTest extends TestBase {
    @Test
    @Description("Verify that user can submit Contact Us form successfully")
    public void contactUsFormTest() {
        Allure.step("Open homepage", () ->
        DriverFactory.getDriver().get("http://automationexercise.com"));

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible", () ->
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is NOT visible"));

        homePage.clickContactUs();

        Allure.step("Verify 'Get In Touch' section is visible", () ->
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'GET IN TOUCH' is not visible"));

        String filePath = new File("src/test/resources/testfile.txt").getAbsolutePath();

        Allure.step("Fill contact form and submit", () ->
        contactUsPage
                .enterName("ravici")
                .enterEmail("ravici@mail.com")
                .enterSubject("Automation Test")
                .enterMessage("This is a test message")
                .uploadFile(filePath)
                .clickSubmitAndAcceptAlert()
        );

        Allure.step("Verify success message", () ->
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message not displayed"));

        contactUsPage.clickHome();

        Allure.step("Verify user is redirected to Home page", () ->
        Assert.assertTrue(homePage.isHomePageVisible(), "Did not land on Home page"));
    }
}