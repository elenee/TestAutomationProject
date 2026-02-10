package api;
import client.BrandsClient;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
