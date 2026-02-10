package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    private By testCasesHeader = By.xpath("//h2/b[text()='Test Cases']");

    public boolean isTestCasesHeaderVisible() {
        return isDisplayed(testCasesHeader);
    }
}
