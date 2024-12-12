
package Day_04;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Practice {
	
	//@Test
	void testJsonResponse() throws JsonProcessingException {
		
		HashMap data= new HashMap();
		data.put("name", "Rajan");
		data.put("lastname", "sethi");
		data.put("age",28);
		
		
		ObjectMapper obj= new ObjectMapper();
		String jsondata=obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
		
		
		
		
	
		
		
		
		//.body("CATALOG.PLANT[2].PRICE", equalTo("$6.81"));
		
		
		
		
		
		
	}
	
	
	@Test
	void test() throws JsonMappingException, JsonProcessingException {
		
		String jsondata="{\r\n"
				+ "  \"name\" : \"Rajan\",\r\n"
				+ "  \"age\" : 28,\r\n"
				+ "  \"lastname\" : \"sethi\"\r\n"
				+ "}";
		ObjectMapper obj= new ObjectMapper();
	Practice c=obj.readValue(jsondata,Practice.class);
	c.getClass();
	
	System.out.println(c);
	
		
	}

}
