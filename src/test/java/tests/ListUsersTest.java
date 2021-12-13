import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListUsersTest {

@Test
    public void findQuantityUsers(){
    given()
        .when()
        .get("https://reqres.in/api/users?page=2")
        .then()
           .statusCode(200)
            //.body("email", equalTo( "lindsay.ferguson@reqres.in"));
            .body("total", equalTo(12));
    }


}
