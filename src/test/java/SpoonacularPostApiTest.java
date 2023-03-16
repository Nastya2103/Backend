import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import DTO.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class SpoonacularPostApiTest extends AbstractTest {
    private static RequestSpecification requestPostSpecification;

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        static void beforePostTest () {
            requestPostSpecification = new RequestSpecBuilder()
                    .addQueryParam("language", "en")
                    .setContentType("application/x-www-form-urlencoded")
                    .build();
            RestAssured.requestSpecification = requestPostSpecification;
        }

        public static RequestSpecification getRequestPostSpecification () {
            return requestPostSpecification;
        }

        @Test
        void postClassifyCuisineMediterraneanTest () {
            void postClassifyCuisineItalianTest () {
                given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("language", "en")
                        .contentType("application/x-www-form-urlencoded")
                        .spec(getRequestSpecification())
                        .spec(getRequestPostSpecification())
                        .formParam("title", "Pork roast with green beans")
                        .formParam("ingredientList", "3 oz pork shoulder")
                        .log().uri()
                        .when()
                        .post(getBaseUrl() + "recipes/cuisine")
                        .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("cuisine", is("Mediterranean"))
                        .log().status();
                .spec(getResponseSpecification())
                        .body("cuisine", is("Italian"));
            }

            @Test
            void postClassifyCuisineIndianTest () {
                given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("language", "en")
                        .contentType("application/x-www-form-urlencoded")
                        .spec(getRequestSpecification())
                        .spec(getRequestPostSpecification())
                        .formParam("title", "Curry")
                        .formParam("ingredientList", "14 ounce canned unsweetened coconut milk")
                        .log().uri()
                        .when()
                        .post(getBaseUrl() + "recipes/cuisine")
                        .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("cuisine", is("Indian"))
                        .log().status();
                .spec(getResponseSpecification())
                        .body("cuisine", is("Indian"));
            }

            @Test
            void postClassifyCuisineMexicanTest () {
                given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("language", "en")
                        .contentType("application/x-www-form-urlencoded")
                        .spec(getRequestSpecification())
                        .spec(getRequestPostSpecification())
                        .formParam("title", "Salsa")
                        .formParam("ingredientList", "1 cup papaya")
                        .log().uri()
                        .when()
                        .post(getBaseUrl() + "recipes/cuisine")
                        .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("cuisine", is("Mexican"))
                        .log().status();
                .spec(getResponseSpecification())
                        .body("cuisine", is("Mexican"));
            }

            @Test
            void postClassifyCuisineVietnameseTest () {
                given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("language", "en")
                        .contentType("application/x-www-form-urlencoded")
                        .spec(getRequestSpecification())
                        .spec(getRequestPostSpecification())
                        .formParam("title", "Pho Bo")
                        .formParam("ingredientList", "4 handfuls bean sprouts")
                        .log().uri()
                        .when()
                        .post(getBaseUrl() + "recipes/cuisine")
                        .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("cuisine", is("Vietnamese"))
                        .log().status();
                .spec(getResponseSpecification())
                        .body("cuisine", is("Vietnamese"));
            }

            @Test
            void postClassifyCuisineChineseTest () {
                given()
                        .queryParam("apiKey", getApiKey())
                        .queryParam("language", "en")
                        .contentType("application/x-www-form-urlencoded")
                        .spec(getRequestSpecification())
                        .spec(getRequestPostSpecification())
                        .formParam("title", "fried rice")
                        .formParam("ingredientList", "6 spring onions")
                        .log().uri()
                        .when()
                        .post(getBaseUrl() + "recipes/cuisine")
                        .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("cuisine", is("Chinese"))
                        .log().status();
                .spec(getResponseSpecification())
                        .body("cuisine", is("Chinese"));
            }
        }
    }
}
