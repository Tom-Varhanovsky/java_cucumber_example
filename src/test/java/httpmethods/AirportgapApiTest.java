package httpmethods;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AirportgapApiTest {

    static String BASE_URI = "https://airportgap.com/api";

    @Test
    public static void GetApiTest() {

        given()
                .baseUri("https://airportgap.com/api")
                .contentType(ContentType.JSON)
                .when()
                .get("/airports/VIE")
                .then()
                .statusCode(200)
                .body("data.id", equalTo("VIE"))
                .body("data.type", equalTo("airport"))
                .body("data.attributes.name", equalTo("Vienna International Airport"))
                .body("data.attributes.city", equalTo("Vienna"))
                .body("data.attributes.country", equalTo("Austria"))
                .log().all();
    }

    @Test
    public static void GetDistanceTest() {

        given()
                .baseUri("https://airportgap.com/api")
                .param("from", "VIE")
                .param("to", "IST")
                .post("/airports/distance")
                .then()
                .statusCode(200)
                .body("data.id", equalTo("VIE-IST"))
                .body("data.type", equalTo("airport_distance"))
                .body("data.attributes.kilometers", equalTo(1224.2883F))
                .body("data.attributes.miles", equalTo(760.2079F))
                .body("data.attributes.nautical_miles", equalTo(660.6023F))
                .log().all();
    }
}
