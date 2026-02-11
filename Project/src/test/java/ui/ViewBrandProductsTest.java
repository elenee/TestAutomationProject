package ui;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.DriverFactory;

@Epic("UI Tests")
@Feature("Brand Products")
public class ViewBrandProductsTest extends TestBase {

    @Test
    @Description("Verify that user can view products filtered by Brand")
    public void viewBrandProductsTest() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        Allure.step("1. & 2. Launch browser and navigate to URL", () ->
                DriverFactory.getDriver().get("http://automationexercise.com")
        );

        Allure.step("3. Click on 'Products' button", productPage::clickProductsButton);

        Allure.step("4. Verify that Brands are visible on left side bar", () ->
                Assert.assertTrue(productPage.isBrandsSidebarVisible(), "Brands sidebar is NOT visible")
        );

        Allure.step("5. Click on any brand name", () -> {
            productPage.clickFirstBrand();
        });

        Allure.step("6. Verify navigation to brand page and products displayed", () -> {
            String title = productPage.getBrandPageTitle();
            Assert.assertTrue(title.toUpperCase().contains("BRAND"), "Not on Brand page");
        });

        Allure.step("7. On left side bar, click on any other brand link", productPage::clickSecondBrand);

        Allure.step("8. Verify navigation to that brand page", () -> {
            String title = productPage.getBrandPageTitle();
            Assert.assertTrue(title.toUpperCase().contains("BRAND"), "Not on second Brand page");
        });
    }
}