import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_PUT_Request {

    @Test
    public void PutUserUpdate(){

        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "morpheus");
        requestParams.put("job", "zion resident");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.PUT, "/api/users/2");

        //print response in console
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is " +responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("Status Code "+statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
