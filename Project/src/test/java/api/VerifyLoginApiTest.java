package api;

import client.UserClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("API Tests")
public class VerifyLoginApiTest {

    private final UserClient userClient = new UserClient();
    private final String testEmail = "ketevansamukashvili@gmail.com";
    private final String testPassword = "BatmanBatman";

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    @Description("Verify POST request to /verifyLogin with valid credentials returns status code 200 and 'User exists!' message")
    public void verifyLoginWithValidDetails() {
        Allure.step("Send POST request to /verifyLogin with valid email and password", () -> {
            userClient.verifyLogin(testEmail, testPassword)
                    .then()
                    .log().body()
                    .statusCode(200)
                    .body("message", equalTo("User exists!"));
        });
    }
}