package httpmethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

public class StepDefinitions {

    String token;

    @Given("I am authorized user")
    public void IamAuthrizedUser() {
        token = given().baseUri("https://airportgap.com/api")
                .param("email", "MAILHERE")
                .param("password", "PASSWORDHERE")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/tokens")
                .then().statusCode(200).extract().path("token");

        assert !(token.isEmpty());
    }

    @Then("list of my favourite airports contains VIE airport")
    public void ICanAccessListOfMyFavouriteAirports() throws InterruptedException {
        given()
                .baseUri("https://airportgap.com/api")
                .header("Authorization", ("Token " + token))
                .contentType(ContentType.JSON)
                .when()
                .get("/favorites")
                .then()
                .statusCode(200)
                .body("data.attributes.airport.iata", contains("VIE"));

    }

}
