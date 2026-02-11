package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

@Epic("UI Tests")
public class VerifyProductQuantityTest extends TestBase {

    @Description("Verify that product quantity in the cart is correct after adding multiple items")
    @Test
    public void verifyProductQuantityInCart() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        CartPage cartPage = new CartPage(DriverFactory.getDriver());

        Allure.step("Verify that home page is visible", () -> {
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        });

        Allure.step("Open first product details", () -> {
            homePage.clickFirstProductView();
            Assert.assertTrue(productPage.isProductDetailVisible(), "Product detail page is not visible");
        });

        Allure.step("Set product quantity and add to cart", () -> {
            productPage.setQuantity(4)
                    .clickAddToCart()
                    .clickViewCart();
        });

        Allure.step("Verify product quantity in the cart", () -> {
            int actualQty = cartPage.getProductQuantity();
            Assert.assertEquals(actualQty, 4, "Product quantity in cart is incorrect!");
        });
    }
}
