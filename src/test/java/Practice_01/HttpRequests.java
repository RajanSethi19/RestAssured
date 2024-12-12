package Practice_01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class HttpRequests {

	@Test
	void testPostUsingHashmap() {
		
		Pojovar p= new Pojovar();
		p.setAge(20);
		p.setGender("female");
		p.setName("Rajan");
		p.setPhoneno("9996464201");
		
		given()
		.contentType("application/json")
		.body(p)
		.when()
		.post("http://localhost:3000/studentdetail")
		
		.then()
		.statusCode(201)
		.body("gender",equalTo("female"));
		
		       
		
	}

}
