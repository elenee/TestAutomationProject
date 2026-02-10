package api;

import client.UserClient;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserApiTest {
    private final UserClient userClient = new UserClient();
    private final String testEmail = "ketevansamukashvili@gmail.com";
    @BeforeClass
    public void setup() {
        RestAssured.registerParser("text/html", Parser.JSON);
    }
    @Test
    public void verifyGetUserDetailByEmail() {
        userClient.getUserDetail(testEmail)
                .then()
                .log().body()
                .statusCode(200);
    }
}