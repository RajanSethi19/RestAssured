package Day_01;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Practice {
	int id;

	@Test(priority = 1)
	void getuser() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("total", equalTo(12)).body("page", equalTo(2)).log().all();

	}

	@Test(priority = 2)
	void postuser() {

		HashMap data = new HashMap();

		data.put("name", "Rajan");
		data.put("job", "Engineer");
		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

	}

	@Test(priority = 3)
	void updateuser() {

		HashMap data = new HashMap();

		data.put("name", "RajanSethi");
		data.put("job", "Automation Engineer");
		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id).then().statusCode(200).log().all();

	}
	
	@Test(priority = 4)
	void deleteuser() {

		given()

				.when()
				.delete("https://reqres.in/api/users/"+id)

				.then()
				.statusCode(204)
				.log().all();

	}

}
