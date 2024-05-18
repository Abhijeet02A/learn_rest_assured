package com.abhi.RAssured.stepdefs;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetMethodCaller {
	private Response response;
	@Given("I send request to reqres api")
	public void i_send_request_to_reqres_api() {
	    System.out.println("I am in Given Role - ");
	    response = given().get("https://reqres.in/api/users?page=2");
	}

	@Then("I printed the response")
	public void i_printed_the_response() {
		System.out.println("I am in Then Role - ");
		System.out.println("Here is a response " + response.asPrettyString());
	}
	
	@Given("I send request to reqres on {string}")
	public void i_send_request_to_reqres_on(String pageNumber) {
		response = given().get("https://reqres.in/api/users?page=" + pageNumber);
	}

	@When("The response contains statuscode {string}")
	public void the_response_contains_statuscode(String statusCode) {
		response.then().assertThat().statusCode(Integer.valueOf(statusCode));
		System.out.println(response.asPrettyString());
	}

	@Then("the page node have the same value as {string}")
	public void the_page_node_have_the_same_vale_as(String pageNumber) {
		response.then().
						body("page", is(Integer.valueOf(pageNumber)));
	}

	@Then("count of object in data array is equal to value in per_page")
	public void count_of_object_in_data_array_is_equal_to_value_in_per_page() {
		ValidatableResponse res = response.then();//.body("", null)
		System.out.println(response.body().path("data.id", "").toString());
		String per_pagevalue = response.body().path("per_page", "").toString();
		res.body("data.collect.size()", equalTo(Integer.valueOf(per_pagevalue)));
	}

	@Then("print first name of all user in data")
	public void print_first_name_of_all_user_in_data() {
	    System.out.println(response.body().path("data.first_name", "").toString());
	}

	@Then("print user whose id is greater than {string}")
	public void print_user_whose_id_is_greater_than(String string) {
		List<Integer> ids = response.body().path("data.id", "");
		int comparisonValue = Integer.valueOf(string); 
		for (Integer id : ids) {
		    int idValue = Integer.valueOf(id);
		    if (idValue > comparisonValue) {
		        System.out.print(id);
		    }
		}
	}
}
