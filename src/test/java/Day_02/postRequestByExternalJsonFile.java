package Day_02;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class postRequestByExternalJsonFile {
	//Post Request Body Using External Json File
	
		@Test(priority=1)
		void testPostUsingExternalJsonFile() throws FileNotFoundException {
			
			
			
		
		File f= new File(".\\body.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
			given()
			.contentType("application/json")
			.body(data.toString())
			
			.when()
			.post("http://localhost:3000/people")
			
			.then()
			.statusCode(201)
			.body("firstName",equalTo("Rajan"))
			.body("lastName",equalTo("Sethi"))
			.body("age",equalTo(28))
			//.body("number",equalTo( "9996464204"))
			.log().all();	
			
		}
}
