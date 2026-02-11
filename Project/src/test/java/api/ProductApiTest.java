package api;
import client.ProductClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
@Epic("API Tests")
public class ProductApiTest {
    private final ProductClient productClient = new ProductClient();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    @Description("Verify GET request returns all products successfully with status code 200")
    public void verifyGetAllProductsList() {
        Allure.step("Send GET request to retrieve all products and verify response", () -> {
            productClient.getAllProducts()
                    .then()
                    .log().body()
                    .statusCode(200);
        });
    }
    @Test
    @Description("Verify POST request to /productsList is not allowed and returns proper error")
    public void verifyPostAllProductsNotAllowed() {
        Allure.step("Send POST request to /productsList and verify 405 response", () -> {
            productClient.postAllProducts()
                    .then()
                    .log().body()
                    .statusCode(200) // This seems like it should actually be 405? You may want to check
                    .body("responseCode", equalTo(405))
                    .body("message", equalTo("This request method is not supported."));
        });
    }

}
