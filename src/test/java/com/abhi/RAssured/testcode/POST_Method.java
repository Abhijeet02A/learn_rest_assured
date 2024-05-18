package com.abhi.RAssured.testcode;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;

import io.restassured.response.Response;

public class POST_Method {
	/**
	 * Important is static import of io.restassured.RestAssured.*
	 * If you are using IDE almost all methods will pop out
	 * remember the BDD flow
	 * given() - give data
	 * when() - to take action, sending request
	 * then() - action on response and validation
	 * @throws FileNotFoundException 
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		//body From POJO Class
//		POJO_User data = new POJO_User("Welcome", "Plumber");
		
		//Request body from file contents
		File f = new File("src\\test\\resources\\request_templates\\reqres_user.json");
		FileReader fr = new FileReader(f);
		JSONTokener tokener = new JSONTokener(fr);
		JSONObject body = new JSONObject(tokener);

		Response res = given().contentType(ContentType.JSON).body(body.toString()).post("https://reqres.in/api/users");
		
		System.out.println("+++  Printing Response  +++");
		System.out.println(res.statusCode());
		System.out.println(res.getBody().asString());
	}

}
