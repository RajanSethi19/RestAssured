package Day_05;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;
public class FileUploadAndDownlaod {
	
	
	@Test
	
	void singleFileUpload() {
		
		File myfile= new File("D:\\Rajan_Pic.jpg");
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		
		.post("https://petstore.swagger.io/v2/pet/1/uploadImage")
		.then()
		.statusCode(200)
		.body("type",equalTo("unknown"))
		.log().all();
		
	}

}
