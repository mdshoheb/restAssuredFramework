package test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class Get_APITest {
	
	@Test(enabled = false)
	public void getStatusCodeValidation() {
		RestAssured
		.given().log().all()
		.get("https://reqres.in/api/users/2")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getCallBodyRespoonse() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/5")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("Eva Air"))
		.body("country", equalTo("Taiwan"))
		.body("established", equalTo("1989"))
		.body("slogan", equalTo("Sharing the World, Flying Together"));
	}
	
	@Test(enabled = false)
	public void getCallComplexBodyValidation() {
		RestAssured
		.given().log().all()
		.get("https://reqres.in/api/users/2")
		.then()
		.log().all()
		.statusCode(200)
		.body("data.first_name", equalTo("Janet"))
		.body("data.email", equalTo("janet.weaver@reqres.in"))
		.body("data.last_name", equalTo("Weaver"));
	}
	
	@Test(enabled = true)
	public void getCallListValidation() {
		String response =
		RestAssured
		.given()
		.get("https://api.instantwebtools.net/v1/airlines")
		.then()
		.extract().response().asString();
		System.out.println(response);
		
		JsonPath path = JsonPath.from(response);
		List<String> airlineName = path.getList("name");
		for(String name : airlineName) {
			System.out.println(name);
		}
	}
	
}
		

		
		
				
	
		
	
	
		
