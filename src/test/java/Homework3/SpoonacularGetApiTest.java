package Homework3;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.Endpoints;
import Homework3.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;