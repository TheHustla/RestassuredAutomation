import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TC003_POST_Request {

    @Test
    public void CreateUser(){

        RestAssured.baseURI="https://reqres.in/";

        RequestSpecification httpRequest=RestAssured.given();

        JSONObject requestParams= new JSONObject();

        requestParams.put("name", "morpheus");
        requestParams.put("job","leader");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST, "/api/users");

        //print response in console
        String responseBody=response.getBody().asString();
        System.out.println("Response body is "+responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("StatusCode is "+statusCode);
        Assert.assertEquals(statusCode, 201);

    }
}
