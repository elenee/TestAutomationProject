package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

@Epic("UI Tests")
public class SearchProductTest extends TestBase {
    @Test
    @Description("Verify that user can search for a product successfully")
    public void searchProductTest() {

        Allure.step("Open homepage", () ->
        DriverFactory.getDriver().get("http://automationexercise.com"));

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible", () ->
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible"));

        productPage.clickProductsButton();

        Allure.step("Verify ALL PRODUCTS page is visible", () ->
        Assert.assertTrue(productPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible"));

        String productName = "Jeans";
        productPage.enterSearchTerm(productName).clickSearchButton();

        Allure.step("Verify 'SEARCHED PRODUCTS' title is visible", () ->
        Assert.assertTrue(productPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' title not visible"));

        Assert.assertTrue(productPage.areAllProductsRelatedToSearchVisible(productName),
                "Not all products are related to search");
    }
}