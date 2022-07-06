import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {

    @Test
    public void PostUsers(){

        RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";

        RequestSpecification httpRequest=RestAssured.given();

        // Request payload sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("id","1");
        requestParams.put("userName", "string");
        requestParams.put("password", "string");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST, "/api/v1/Users");

        //print response in console
        String responseBody=response.getBody().asString();
        System.out.println("Response body is: "+responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("StatusCode is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

     /*   //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "Success");  */
    }
}
