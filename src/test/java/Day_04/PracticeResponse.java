package Day_04;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PracticeResponse {

	@Test
	void testResponse() {

		// Approach 1
		/*
		 * given() .contentType(ContentType.JSON) .when()
		 * .get("http://localhost:3000/store") .then() .statusCode(200)
		 * .header("Content-Type", "application/json") .body("data[3].email",equalTo
		 * ("joanie.toy@hackett.com"));
		 */

		// Approach 2

		/*
		 * Response res=given() .contentType(ContentType.JSON) .when()
		 * .get("http://localhost:3000/store"); int status=res.getStatusCode();
		 * 
		 * Assert.assertEquals(status,200);
		 * Assert.assertEquals(res.getHeader("Content-Type"), "application/json");
		 * 
		 * 
		 * String email=res.jsonPath().get("data[3].email").toString();
		 * Assert.assertEquals(email,"joanie.toy@hackett.com");
		 * 
		 */

		// print all the email id in data by creating json object
		
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

	
		JSONObject jo = new JSONObject(res.asString());
		boolean status = false;
		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {

			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();

			System.out.println(email);

			if (email.equals("joanie.toy@hackett.com")) {
				status = true;
				break;
			}

			
		}
		Assert.assertEquals(status, true);
	}

}
