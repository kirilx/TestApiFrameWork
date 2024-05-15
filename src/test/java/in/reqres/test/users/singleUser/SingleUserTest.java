

package in.reqres.test.users.singleUser;
import in.reqres.model.responce.register.UserResponse;
import in.reqres.test.ApiTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SingleUserTest extends ApiTestBase {

    @Test
    public void testGetSingleUser() {
        UserResponse response = given()
                .when()
                .pathParam("userId", 2)
                .get("users/{userId}")
                .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        Assert.assertEquals(response.getData().getId(), 2, "User Id does not match the value ");
        Assert.assertEquals(response.getData().getEmail(), "janet.weaver@reqres.in", "Email does not match");
        Assert.assertEquals(response.getData().getFirstName(), "Janet", "First name does not match");
        Assert.assertEquals(response.getData().getLastName(), "Weaver", "Last name does not match");
        Assert.assertEquals(response.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg", "Avatar does not match");

        Assert.assertEquals(response.getSupport().getUrl(), "https://reqres.in/#support-heading", "Support URL does not match");
        Assert.assertTrue(response.getSupport().getText().contains("To keep ReqRes free, contributions towards server costs are appreciated!"), "Support text does not contain expected message");
    }
    @Test
    public void testGetSingleUser2() {
        UserResponse response = given()
                .when()
                .pathParam("userId", 2)
                .get("users/{userId}")
                .then()
                .statusCode(200)
                .body("data.id",equalTo(2))
                .body("data.email",equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("support.text",containsString("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .extract().as(UserResponse.class);
    }
}
