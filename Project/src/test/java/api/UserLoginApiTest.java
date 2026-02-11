package api;

import client.UserClient;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

@Epic("API tests")
@Feature("User Deletion")
public class UserLoginApiTest {
    private final UserClient userClient = new UserClient();

    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }
    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("POST To Verify Login with invalid details")
    public void verifyLoginWithInvalidCredentials() {
        String invalidEmail = "user@gmail.com";
        String invalidPassword = "paroli1";

        Allure.step("Verify that logging in with invalid details returns 404", () -> {
            userClient.verifyLogin(invalidEmail, invalidPassword)
                    .then()
                    .statusCode(200)
                    .body("responseCode", equalTo(404))
                    .body("message", equalTo("User not found!"));
        });
    }
}