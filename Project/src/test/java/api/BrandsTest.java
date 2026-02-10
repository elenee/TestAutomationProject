package api;
import client.BrandsClient;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class BrandsTest {
    private final BrandsClient brandsClient = new BrandsClient();
    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }
    @Test
    public void getAllBrands_verifyResponse() {
        brandsClient.getAllBrands()
                .then()
                .log().body()
                .statusCode(200);
    }
    @Test
    public void putAllBrands_verifyMethodNotAllowed() {
        brandsClient.putAllBrands()
                .then()
                .log().body()
                .statusCode(200)
                .body("responseCode", equalTo(405))
                .body("message", equalTo("This request method is not supported."));
    }
}
