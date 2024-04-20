package homework;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class task06 {

    @Test
    public void test(){
        Response response = given().get("https://reqres.in/api/unknown/3");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("data.id");
        String name = jsonPath.getString("data.name");
        int year = jsonPath.getInt("data.year");
        String color = jsonPath.getString("data.color");
        String pantone_value = jsonPath.getString("data.pantone_value");
        String url = jsonPath.getString("support.url");
        String text = jsonPath.getString("support.text");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(id , 3);
        softAssert.assertEquals(name , "true red");
        softAssert.assertEquals(year , 2002);
        softAssert.assertEquals(color , "#BF1932");
        softAssert.assertEquals(pantone_value , "19-1664");
        softAssert.assertEquals(url , "https://reqres.in/#support-heading");
        softAssert.assertEquals(text , "To keep ReqRes free, contributions towards server costs are appreciated!");

        softAssert.assertAll();


    }


}
