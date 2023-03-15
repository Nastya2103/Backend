import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularRequestChainApiTest extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void mealPlanTest() {
        String id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", "3a094ed5ef31f6b09c7ae737c8742701b7d4a63d")
                .body("{\n"
                        + " \"date\": 1589500800,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"2 bananas\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .log().uri()
                .when()
                .post("https://api.spoonacular.com/mealplanner/nastya_2103/items")
                .then()
                .statusCode(200)
                .log().status()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "3a094ed5ef31f6b09c7ae737c8742701b7d4a63d")
                .queryParam("apiKey", getApiKey())
                .log().uri()
                .delete("https://api.spoonacular.com/mealplanner/nastya_2103/items/" + id)
                .then()
                .statusCode(200)
                .log().status();
    }
}