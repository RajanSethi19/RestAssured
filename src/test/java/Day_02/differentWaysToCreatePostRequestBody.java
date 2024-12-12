package Day_02;

import  org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class differentWaysToCreatePostRequestBody {
	
	//Post request body using HashMap
	
	@Test(priority=1)
	void testPostUsinhHashmap() {
		
		HashMap data= new HashMap();
		data.put("firstName", "Joe");
		data.put("lastName","Jackson");
		data.put("gender","male");
		data.put("age",28);
		data.put(  "number","7349282382");
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/people")
		
		.then()
		.statusCode(201)
		.body("firstName",equalTo("Joe"))
		.body("lastName",equalTo("Jackson"))
		.body("age",equalTo(28))
		//.header("Content-Type", "application/json; charset=utf-8")
		.log().all();	
		
	}
	
	@Test(priority=2)
	void testDelete()
	{
		
		
		
		given()
		
		.when()
		.delete("http://localhost:3000/people/fa5b")
		
		.then()
		.statusCode(200);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
