package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productQuantityInput = By.xpath("//*[@id=\"product-1\"]/td[4]/button");

    public int getProductQuantity() {
        String qty = driver.findElement(productQuantityInput).getText();
        return Integer.parseInt(qty);
    }
}
