package steps;
//import io.cucumber.java8.*;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
//import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

public class stepdefinition {
    Response response;
//    Details d = new Details();
    public void getResponse() {
        Response res;
        RestAssured.baseURI = "https://reqres.in/";
        res = RestAssured.given().contentType(ContentType.JSON).when().get("/api/users");
        int statuscode = res.getStatusCode();
        System.out.println("status is:" + statuscode);

    }

    @Given("As an end user, I want to retrieve the list of users")
    public void setupEndpoint() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";
    }

    @When("I send the request with page number as “{int}”")
    public void the_request_is_send_to_server_with_page_number_as(Integer pageNumber) {


        String response1 = given().
                queryParam("page", pageNumber).
                when().
                get().
                then().
                contentType(ContentType.JSON)
                .log().all().
                extract().asString();
        JsonPath js = new JsonPath(response1);
        System.out.println("Email address of the first record retrieved :"+js.getString("data[0].email"));
    }


    @Then("I should be able to validate the response successfully")
    public void validateTheResponseOfFirstUserRecordHavingEmailAs ()
    {
        stepdefinition ob = new stepdefinition();
        ob.getResponse();
    }

    public HashMap<Object, Object> map = new HashMap<Object, Object>();
    @Given("As an end user, I want to add new set of user details")
    public void theValidEndpointWithPayloadToCreateUser () {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";

        map.put("name", "yogesh");
        map.put("job", "software engineer");
        map.put("email","yogi12@gmail.com");


    }

    @When("the request is send to the server")
    public void theRequestIsSendToTheServer () {

        response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201).contentType(ContentType.JSON).
                extract().response();
    }

    @Then("the new user must be created with name as “{}” , {string}, {string}")
    public void theNewUserMustBeCreatedWithNameAs(String name, String job, String email) {
        String userName = response.path("name");
        Assert.assertEquals(userName, name);
        String job1 = response.path("job");
        Assert.assertEquals(job1, job);
        String emailID = response.path("email");
        Assert.assertEquals(emailID, email);
    }



}