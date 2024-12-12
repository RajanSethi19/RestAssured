package Day_03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	//@Test
	void testcookies() {

		given()

				.when().get("https://www.google.com/")

				.then().cookie("AEC", "AZ6Zc-Uq_b83GFQq6iSXpGIM3oNCL8Gu3X1CJmC3QHf3grLcr0s_tXMOVm0").log().all();

	}

	@Test
	void getCookiesInfo() {

		Response res = given()
				.when()

				.get("https://www.google.com/");
//For single cookie
		/*
		 * String cookie_value = res.getCookie("AEC");
		 * System.out.println("Value of cookie: " + cookie_value);
		 */
		
		//For multiple cookies
		
		Map<String,String> cookies_values=res.getCookies();
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()) {
			
			String cookie_value = res.getCookie(k);
			
			System.out.println("Key:- "+ k+" value "+cookie_value );
		}
		
		

	}

}
