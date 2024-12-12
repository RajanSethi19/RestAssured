package Day_03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {

	//@Test

	void testHeaders() {

		given()
		
		.when()
		
        .get("https://www.google.com/")
        
        .then()
        
        .header("Content-Type", "text/html; charset=ISO-8859-1")
        .header("Cache-Control", "private, max-age=0")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");

	}
	
	@Test

	void getHeaders() {

		Response res=given()
		
		.when()
		
        .get("https://www.google.com/");
        
        //Single header
		/*
		 * String header=res.getHeader("Content-Type"); System.out.println(header);
		 */
		//Multiple header
		
		Headers hd=res.getHeaders();
		
		for(Header h:hd) {
			
			System.out.println(h.getName() +"     "+ h.getValue());

		}
        
        

	}
	
	
	
	
	
	
	
	
	
	
	

}
