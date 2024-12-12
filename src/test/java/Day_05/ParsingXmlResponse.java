package Day_05;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class ParsingXmlResponse {

	@SuppressWarnings("deprecation")

	@Test
	void testXmlResponse() {

		// Approach 1
		/*
		 * given() .when()
		 * //.get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
		 * .get("http://www.w3schools.com/xml/plant_catalog.xml") .then()
		 * .statusCode(200) .header("Content-Type", "text/xml")
		 * .body("CATALOG.PLANT[1].PRICE", equalTo("$9.37"));
		 * 
		 */

		// Approach 2

	/*	Response res = given().when().get("http://www.w3schools.com/xml/plant_catalog.xml");

		int status = res.statusCode();

		Assert.assertEquals(status, 200);

		Assert.assertEquals(res.header("Content-Type"), "text/xml");
		
		
		String price=res.xmlPath().get("CATALOG.PLANT[1].PRICE").toString();
		System.out.println(price);
		
		*/
		
		//Printing all the price by creating xmlObject
		Response res = given().when().get("http://www.w3schools.com/xml/plant_catalog.xml");

		
		XmlPath obj= new XmlPath(res.asString());
		List<String> data=obj.getList("CATALOG.PLANT");
		//System.out.println(data);
		int x=data.size();
		//System.out.println(x);
		System.out.println("------------");
		Assert.assertEquals(x,36);
		//Verify all price in list
		List<String> price=obj.getList("CATALOG.PLANT.PRICE");
		boolean status=false;
		for(String Prices:price) {
			
			if(Prices.equals("$6.81")) {
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
		

	}

}
