import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import DTO.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class SpoonacularGetApiTest extends AbstractTest {
    private static ResponseSpecification responseGetSpecification;

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        static void beforeGetTest () {
            responseGetSpecification = new ResponseSpecBuilder()
                    .expectBody("totalResults", notNullValue())
                    .expectBody("results[0]", hasKey("id"))
                    .expectBody("results[0]", hasKey("title"))
                    .build();
            RestAssured.responseSpecification = responseGetSpecification;
        }

        public static ResponseSpecification getResponseGetSpecification () {
            return responseGetSpecification;
        }

        @Test
        void getSearchRecipesCuisineTest () {
            given()
                    .queryParam("apiKey", getApiKey())
                    .spec(getRequestSpecification())
                    .queryParam("cuisine", "italian")
                    .log().uri()
                    .when()
                    .get(getBaseUrl() + "recipes/complexSearch")
                    .get(getBaseUrl() + Endpoints.getSearchRecipes)
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("totalResults", notNullValue())
                    .body("results[0]", hasKey("id"))
                    .body("results[0]", hasKey("title"))
                    .log().status();
                .spec(getResponseSpecification())
                    .spec(getResponseGetSpecification());
        }

        @Test
        void getSearchRecipesCuisineDietTest () {
            given()
                    .queryParam("apiKey", getApiKey())
                    .spec(getRequestSpecification())
                    .queryParam("cuisine", "italian")
                    .queryParam("diet", "Gluten Free")
                    .log().uri()
                    .when()
                    .get(getBaseUrl() + "recipes/complexSearch")
                    .get(getBaseUrl() + Endpoints.getSearchRecipes)
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("totalResults", notNullValue())
                    .body("results[0]", hasKey("id"))
                    .body("results[0]", hasKey("title"))
                    .log().status();
                .spec(getResponseSpecification())
                    .spec(getResponseGetSpecification());
        }

        @Test
        void getSearchRecipesIgnorePantryInstructionsRequiredTest () {
            given()
                    .queryParam("apiKey", getApiKey())
                    .spec(getRequestSpecification())
                    .queryParam("ignorePantry", false)
                    .queryParam("instructionsRequired", true)
                    .log().uri()
                    .when()
                    .get(getBaseUrl() + "recipes/complexSearch")
                    .get(getBaseUrl() + Endpoints.getSearchRecipes)
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("totalResults", notNullValue())
                    .body("results[0]", hasKey("id"))
                    .body("results[0]", hasKey("title"))
                    .log().status();
                .spec(getResponseSpecification())
                    .spec(getResponseGetSpecification());
        }

        @Test
        void getSearchRecipesCuisineIncludeIngredientsTypeTest () {
            given()
                    .queryParam("apiKey", getApiKey())
                    .spec(getRequestSpecification())
                    .queryParam("cuisine", "italian")
                    .queryParam("includeIngredients", "tomato")
                    .queryParam("type", "sauce")
                    .log().uri()
                    .when()
                    .get(getBaseUrl() + "recipes/complexSearch")
                    .get(getBaseUrl() + Endpoints.getSearchRecipes)
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("totalResults", notNullValue())
                    .body("results[0]", hasKey("id"))
                    .body("results[0]", hasKey("title"))
                    .log().status();
                .spec(getResponseSpecification())
                    .spec(getResponseGetSpecification());
        }

        @Test
        void getSearchRecipesSortDirectionDietMaxReadyTimeTest () {
            given()
                    .queryParam("apiKey", getApiKey())
                    .spec(getRequestSpecification())
                    .queryParam("sortDirection", "asc")
                    .queryParam("diet", "Gluten Free")
                    .queryParam("maxReadyTime", 25)
                    .log().uri()
                    .when()
                    .get(getBaseUrl() + "recipes/complexSearch")
                    .get(getBaseUrl() + Endpoints.getSearchRecipes)
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("totalResults", notNullValue())
                    .body("results[0]", hasKey("id"))
                    .body("results[0]", hasKey("title"))
                    .log().status();
                .spec(getResponseSpecification())
                    .spec(getResponseGetSpecification());
        }
    }
}