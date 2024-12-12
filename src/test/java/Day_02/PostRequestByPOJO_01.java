package Day_02;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostRequestByPOJO_01 {

	
	//Post Request Body Using POJO
	
		@Test(priority=1)
		void testPostUsingPojo() {
			
			Pojo_Variable  data=new Pojo_Variable();
			data.setFirstname("RAJAN_01");
			data.setLastname("SETHI");
			data.setGender("male");
			data.setAge(28);
			data.setNumber("9996464204");
			
			
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("http://localhost:3000/people")
			
			.then()
			.statusCode(201)
			.body("firstname",equalTo("RAJAN_01"))
			.body("lastname",equalTo("SETHI"))
			.body("age",equalTo(28))
			.body("number",equalTo("9996464204"))
			.log().all();	
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
