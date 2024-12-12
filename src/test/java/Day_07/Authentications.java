package Day_07;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {
	
	//@Test
	void testBsicAuthentication() {
		given()
		.auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
		
		
	}
	//@Test
	void testdigestAuthentication() {
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
		
		
	}
	@Test
	void testpreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));	
	}
	
	
	

}
