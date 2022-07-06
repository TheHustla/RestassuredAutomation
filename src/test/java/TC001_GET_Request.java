import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {

    @Test
    void GetUsers(){

        //Specify base URL
        RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";

        //Basic Authentication

        PreemptiveBasicAuthScheme authScheme =new PreemptiveBasicAuthScheme();
        authScheme.setUserName("Eray");
        authScheme.setPassword("testpassword");

        RestAssured.authentication=authScheme;

        //Request Object
        RequestSpecification httpRequest=RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/api/v1/Users");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response body is:" +responseBody);

        //status code validation
        int  statusCode = response.getStatusCode();
        System.out.println("statusCode is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("statusLine is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

}
