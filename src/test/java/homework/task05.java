package homework;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class task05 {


    @Test
    public void test(){
        Response response = given().get("https://reqres.in/api/users/23");
        response.prettyPrint();

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server" , "cloudflare")
                .body(equalTo("{}"));
    }


}
