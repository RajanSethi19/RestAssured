package Day_06;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.testng.annotations.Test;

public class JsonSchemaValidation {
	
	
	@Test
	void jsonScemavalidate() {
		
		given()
		.when()
		.get("http://localhost:3000/people")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
		
		
	}

}
