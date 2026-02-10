package api;

import client.UserClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {
    private final UserClient userClient = new UserClient();

    @Test
    public void verifyUserDetailRetrieval() {
        String testEmail = "tester@test.com";
        Response response = userClient.getUserDetail(testEmail);

        String rawBody = response.asString();
        String jsonOnly = rawBody.substring(rawBody.indexOf("{"), rawBody.lastIndexOf("}") + 1);
        JsonPath jp = new JsonPath(jsonOnly);

        Assert.assertEquals(jp.getInt("responseCode"), 200);

        User user = new User();
        user.setName(jp.getString("user.name"));
        user.setEmail(jp.getString("user.email"));
        user.setCity(jp.getString("user.city"));
        user.setCountry(jp.getString("user.country"));

        Assert.assertEquals(user.getEmail(), testEmail);
        Assert.assertEquals(user.getCity(), "virginia");

        System.out.println(user);
    }
}