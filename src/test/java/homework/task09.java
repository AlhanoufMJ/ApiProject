package homework;

import base_urls.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;
import testData.JsonPlaceHolderUserTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class task09 {

    @Test
    public void test(){
        //Set the Url
        spec.pathParams("first", "v2" , "second" , "user");

        // create an empty map and assign values
        Map<String , Object> expectedData = JsonPlaceHolderUserTestData.expectedDataMap(1,"john01" ,"John" , "Doe" ,
                "John101@gmail.com" ,"123456" ,  "654321" ,1  );

        //Send the request and post the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}/{second}/");
        response.prettyPrint();
        // Assertions
        response
                .then()
                .statusCode(200)
                .body("message", equalTo("1")
                );

    }
}
