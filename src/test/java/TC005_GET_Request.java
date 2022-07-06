import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_Request {

    @Test
    void ValidatingHeaders(){

        //Specify base URL
        RestAssured.baseURI="https://documenter.getpostman.com/";

        //Request Object
        RequestSpecification httpRequest=RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/view/9625258/SzS8tQrQ#2f9ee0f0-cdf4-4781-984b-aa1cedbcd4d7/api/registration");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response body is:" +responseBody);


        //validating headers
        String contentType = response.header("X-Content-Type-Options");
        System.out.println("Content type is:"  + contentType);
        Assert.assertEquals(contentType, "nosniff");

        //validating Encoding gzip
        String contentEncoding = response.header("Content-Encoding");
        System.out.println("Content type is:"  + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

    }


}
