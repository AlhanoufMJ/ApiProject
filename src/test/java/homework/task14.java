package homework;

import base_urls.GetEmployeeBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class task14 {

    @Test
    void test(){
        //Set the url
        spec.pathParams("first", "employees");

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)
                .body("data", hasSize(24)//the number of employees
                        ,"data.employee_name",hasItems("Tiger Nixon","Garrett Winters")
                        ,"data.employee_age.max()", equalTo(66)
                        ,"data.find { it.employee_age == 19 }.employee_name", equalTo("Tatyana Fitzpatrick")
                        ,"data.employee_salary.sum()", equalTo(6644770));

        List<String> salaryAbove32 = response.jsonPath().getList("data.findAll{it.employee_salary==320800}.employee_name");//Use findAll{} where the list starts. It starts as 'data' key's value
        List<String> ageAbove40 = response.jsonPath().getList("data.findAll{it.employee_age>40}.employee_name");
        System.out.println("salaryAbove32 = " + salaryAbove32);
        System.out.println("ageAbove40 = " + ageAbove40);


    }
}
