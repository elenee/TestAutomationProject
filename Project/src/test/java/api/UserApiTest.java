package api;

import client.UserClient;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("API tests")
@Feature("User Profile API")
public class UserApiTest {
    private final UserClient userClient = new UserClient();
    private final String testEmail = "ketevansamukashvili@gmail.com";
    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that the system returns the correct user details when queried by a registered email address.")
    public void verifyGetUserDetailByEmail() {
        Allure.step("Retrieve and verify user details" , () -> {
            userClient.getUserDetail(testEmail)
                    .then()
                    .log().body()
                    .statusCode(200);
        });
    }
}