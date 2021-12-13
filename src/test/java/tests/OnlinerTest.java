import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {
    @Test
    public void getCurrencyRubRateTest() {
        given()
                .log().all()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=RUB&type=nbrb")
                .then()
                .log().all()
                .statusCode(200)
                .body("amount", equalTo("3,4512"));
    }

    @Test
    public void getCurrencyUsdRateTest() {
        given()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then()
                .statusCode(200);
    }

    @Test
    public void getCurrencyEurRateTest() {
        given()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=EUR&type=nbrb")
                .then()
                .statusCode(200);
    }
}

