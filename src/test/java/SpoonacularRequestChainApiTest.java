import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import DTO.service.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SpoonacularRequestChainApiTest extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    File addMealReq = new File("src/main/resources/addMealReq.json");

    @Test
    void mealPlanTest() {
        void addMealTest() {
            String id = given()
                    .queryParam("apiKey", getApiKey())
                    .queryParam("hash", "3a094ed5ef31f6b09c7ae737c8742701b7d4a63d")
                    .body("{\n"
                            + " \"date\": 1644881179,\n"
                            + " \"slot\": 1,\n"
                            + " \"position\": 0,\n"
                            + " \"type\": \"INGREDIENTS\",\n"
                            + " \"value\": {\n"
                            + " \"ingredients\": [\n"
                            + " {\n"
                            + " \"name\": \"1 banana\"\n"
                            + " }\n"
                            + " ]\n"
                            + " }\n"
                            + "}")
                    .log().uri()
                    .spec(getRequestSpecification())
                    .queryParam("hash", getHash())
                    .body(addMealReq)
                    .when()
                    .post("https://api.spoonacular.com/mealplanner/nastya_2103/items")
                    .post(Endpoints.mealPlan)
                    .then()
                    .statusCode(200)
                    .log().status()
                    .spec(getResponseSpecification())
                    .extract()
                    .jsonPath()
                    .get("id")
                    .toString();

            given()
                    .queryParam("hash", "3a094ed5ef31f6b09c7ae737c8742701b7d4a63d")
                    .queryParam("apiKey", getApiKey())
                    .log().uri()
                    .delete("https://api.spoonacular.com/mealplanner/nastya_2103/items/" + id)
                    .spec(getRequestSpecification())
                    .queryParam("hash", getHash())
                    .delete(Endpoints.mealPlan + id)
                    .then()
                    .statusCode(200)
                    .log().status();
            .spec(getResponseSpecification());
        }
    }
}