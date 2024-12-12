package Day_01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import  org.testng.annotations.Test;

public class HttpRequest {
int id;
	@Test(priority=1)
	
	void getUser()
	{
	   given()
	 
	    .when()
	       .get("https://reqres.in/api/users?page=2")
	   .then()
	      .statusCode(200)
	       .body("total",equalTo(12))
	       .body("page",equalTo(2))
	       .log().all();
		
	}
	
	
	
   @Test(priority=2)
	
	void createUser()
	{
	   
	   
	   HashMap data= new HashMap();
	   data.put("name","Rajan");
	   data.put("job","Engineer");
	   
	 id=given()
	   .contentType("application/json")
	   .body(data)
	 
	    .when()
	       .post("https://reqres.in/api/users")
	       //we have to capture the id from response to modify by using PUT command so we commented then()
	       .jsonPath().getInt("id");
	       
		/*
		 * .then() .statusCode(201) .log().all();
		 */
	}
   
   
   @Test(priority=3, dependsOnMethods= {"createUser"})
	
  	void updateUser()
  	{
  	   
  	   
  	   HashMap data= new HashMap();
  	   data.put("name","Rajan Sethi");
  	   data.put("job","Senior Software Engineer");
  	   
  	   given()
  	   .contentType("application/json")
  	   .body(data)
  	 
  	    .when()
  	       .put("https://reqres.in/api/users/"+id)
  	   .then()
  	      .statusCode(200)
  	       .log().all();
  		
  	}
   
   @Test(priority=4)
	
 	void deleteUser()
 	{
 	   
 	   given()
 	   
 	 
 	    .when()
 	       .delete("https://reqres.in/api/users/"+id)
 	   .then()
 	      .statusCode(204)
 	       .log().all();
 		
 	}


	

}
