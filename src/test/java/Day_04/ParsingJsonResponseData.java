package Day_04;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
	
	
	@SuppressWarnings("deprecation")
	@Test
	void testJsonResponse() {
		
		//Approach1
		/*
		 * given() .contentType(ContentType.JSON) .when()
		 * .get("http://localhost:3000/store") .then() .statusCode(200)
		 * .header("Content-Type", "application/json")
		 * .body("data[10].name",equalTo("Janiya Reinger"));
		 */
		
		//Approach2
		

		/*Response res=given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/store");
		
		int statuscode=res.getStatusCode();
		
		
		
		Assert.assertEquals(statuscode,200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		String name=res.jsonPath().get("data[10].name").toString();
		Assert.assertEquals(name,"Janiya Reinger");
		*/
		
		//Approach 3(Print all the name in data
		
		

		Response res=given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/store");
		
		//using jsonObject print all the name
		boolean status=false;
		JSONObject jo= new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			
		String name=	jo.getJSONArray("data").getJSONObject(i).get("name").toString();
		System.out.println(name);
		
		if(name.equals("Janiya Reinger")) {
			status=true;
			break;
		}
		
			
			
		}
		
		
		Assert.assertEquals(status, true);
		
		
		
		
		
		
		
	
		
		
		
	}

}
