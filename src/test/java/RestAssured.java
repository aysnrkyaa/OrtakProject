import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RestAssured {


    @Test
    public void test() {
        System.out.println("Api Test");
        ValidatableResponse response=getRequest("BTC");
        response.statusCode(200);
    }

    public ValidatableResponse getRequest(String symbol) {
        ValidatableResponse response = given()
                .request().when().log().all().get("https://prod.roketapp.site/market/currency?symbol={symbol}", symbol)
                .then().log().all();
        return response;
    }


}
