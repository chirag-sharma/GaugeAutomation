package learning;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;




public class StepImplementation {
    @Step("User executes api")
    public void implementation1() {
        /*{
            "userID": "3a01eeaf-7c1d-4c94-9e43-85cb0297c118",
                "username": "Qauser",
                "books": []
        }*/

        String userID = "3a01eeaf-7c1d-4c94-9e43-85cb0297c118";
        String userName = "Qauser";
        String password = "Qauser11!";
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
