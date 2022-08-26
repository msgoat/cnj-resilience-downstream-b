package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.common.test.rest.RestAssuredSystemTestFixture;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * System test that verifies that the REST endpoint works as expected.
 * <p>
 * Assumes that a remote server hosting the REST endpoint is up and running.
 * </p>
 */
public class SabotageEndpointSystemTest {

    private static final RestAssuredSystemTestFixture fixture = new RestAssuredSystemTestFixture();

    @BeforeAll
    public static void onBeforeClass() {
        fixture.onBefore();
    }

    @AfterAll
    public static void onAfterClass() {
        fixture.onAfter();
    }

    @Test
    public void sabotageWithAlwaysFailResultsInStatusCode500() {
        given().get("api/v1/sabotage?alwaysFail=true")
                .then()
                .assertThat()
                .statusCode(200);
        given().get("api/v1/watchedItems/{userId}", "testUser")
                .then()
                .assertThat()
                .statusCode(500);
        given().get("api/v1/sabotage?alwaysFail=false")
                .then()
                .assertThat()
                .statusCode(200);
        given().get("api/v1/watchedItems/{userId}", "testUser")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
