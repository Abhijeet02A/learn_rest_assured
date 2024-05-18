package com.abhi.RAssured.testcode;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class GET_Method {

	public static void main(String[] args) {
		// Create simple get request and check it
		
		
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=1");
		
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.asPrettyString());
//		System.out.println(res.getHeaders());
		System.out.println(res.jsonPath().getString("page"));
		System.out.println("Done");
	}

}
