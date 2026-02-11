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
public class VerifyLoginWithoutEmailTest {

    private final UserClient userClient = new UserClient();
    private final String testPassword = "password";

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    @Description("Verify POST request to /verifyLogin without email returns status code 400 and appropriate error message")
    public void verifyLoginWithoutEmail() {
        Allure.step("Send POST request to /verifyLogin with only password parameter", () -> {
            userClient.verifyLoginWithoutEmail(testPassword)
                    .then()
                    .log().body()
                    .statusCode(200)
                    .body("responseCode", equalTo(400))
                    .body("message", equalTo("Bad request, email or password parameter is missing in POST request."));
        });
    }
}