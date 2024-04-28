package homework;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class task12 {
    @Test
    public void createPetTest(){

        String url = ("https://petstore.swagger.io/v2/pet");


        PetPojo expectedData = new PetPojo(15151515 , "pet1" , "available");
        System.out.println("expectedData = " + expectedData);


        Response response=  given().contentType(ContentType.JSON).body(expectedData).post(url);
        response.prettyPrint();


        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getName(), actualData.getName());

    }
    @Test
    public void updatePetTest(){

        String url = ("https://petstore.swagger.io/v2/pet");


        PetPojo expectedData = new PetPojo(15 , "pet1" , "not available");
        System.out.println("expectedData = " + expectedData);


        Response response=  given().contentType(ContentType.JSON).body(expectedData).put(url);
        response.prettyPrint();

        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getStatus(), actualData.getStatus());

    }
    @Test
    public void deletePetTest(){

        String url = ("https://petstore.swagger.io/v2/pet/15151515");

        Response response=  given().delete(url);
        response.prettyPrint();

        assertEquals(response.statusCode(),200);

    }
}
