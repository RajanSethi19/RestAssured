package Day_02;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostRequestBodyUsingOrgJson {
	
	//Post Request Body Using Org.Json
	int id;
	@Test(priority=1)
	void testPostUsingJson() {
		
	JSONObject data=new JSONObject();
		data.put("firstName", "Rajan");
		data.put("lastName","Sethi");
		data.put("gender","male");
		data.put("age",28);
		data.put(  "number","7349282382");
		id=given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("http://localhost:3000/people")
		.jsonPath().getInt("id");
		
		/*
		 * .then() .statusCode(201) .body("firstName",equalTo("Rajan"))
		 * .body("lastName",equalTo("Sethi")) .body("age",equalTo(28))
		 * //.header("Content-Type", "application/json; charset=utf-8") .log().all();
		 */
		
	}
	
	@Test(priority=2)
	void testDelete()
	{
		
		
		
		given()
		
		.when()
		.delete("http://localhost:3000/people/"+id)
		
		.then()
		.statusCode(404);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
