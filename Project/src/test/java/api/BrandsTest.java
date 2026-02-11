package api;
import client.BrandsClient;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

@Epic("API Tests")
public class BrandsTest {
    private final BrandsClient brandsClient = new BrandsClient();
    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }
    @Test
    @Description("Verify that GET request returns status 200 and brands list.")
    public void getAllBrands_verifyResponse() {
        Allure.step("Send GET request to /brandsList", () ->
                brandsClient.getAllBrands()
                        .then()
                        .log().body()
                        .statusCode(200)
        );
    }
    @Test
    @Description("Verify that PUT request returns responseCode 405.")
    public void putAllBrands_verifyMethodNotAllowed() {
        Allure.step("Send PUT request to /brandsList", () ->
                brandsClient.putAllBrands()
                        .then()
                        .log().body()
                        .statusCode(200)
                        .body("responseCode", equalTo(405))
                        .body("message", equalTo("This request method is not supported."))
        );
    }
}
