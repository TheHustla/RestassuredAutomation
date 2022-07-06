package datadriventesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest_CreateNewUsers {

    @Test
    void createNewUsers(){

        RestAssured.baseURI = "https://reqres.in/api";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("name","eray");

        //Add header stating reguest boy is a JSON
        httpRequest.header("X-Powered-By", "application/json");

        //Add JSON to the body of the request
        httpRequest.body(requestParams.toJSONString());

        //Post Request
        Response response = httpRequest.request(Method.POST,"users");

        //Capture response body to validate
        String responseBody = response.getBody().asString();

        Assert.assertEquals(responseBody.contains("eray"),true);

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);



    }
}
