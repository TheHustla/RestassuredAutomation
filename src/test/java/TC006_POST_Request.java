import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_POST_Request {

    @Test
    public void registerUser(){

        // BaseURL
        RestAssured.baseURI="https://reqres.in/";

        //Request Object
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject requestParam = new JSONObject();

        requestParam.put("email", "eve.holt@reqres.in");
        requestParam.put("password", "pistol");

        //Response Object
        Response response = httpRequest.request(Method.POST, "/api/register");

        // Print response on console
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);

        //status Code Validation
        int statusCode = response.statusCode();
        System.out.println("Status Code is"  +statusCode);
        Assert.assertEquals(statusCode, 200);


    }
}
