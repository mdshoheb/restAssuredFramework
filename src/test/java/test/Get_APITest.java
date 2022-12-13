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
	
	@Test(enabled = false)
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
	
	@Test(enabled = false)
	public void getCallComplexListValidationJsonPath() {
		String response =
		RestAssured
		.given()
		.param("page", "2")
		.log().all()
		.get("https://reqres.in/api/users")
		.then()
		.extract().response().asPrettyString();
		JsonPath path = JsonPath.from(response);
		
		List<Integer> list = path.getList("data.id");
		for(int name : list) {
			System.out.println(name);
		}
	}
	
	@Test(enabled = false)
	public void getCallComplexListValidationJsonPath01() {
		String resposne = 
		RestAssured
		.given()
		.param("page", "2")
		.log().all()
		.get("https://reqres.in/api/users")
		.then()
		.extract().response().asString();	
		JsonPath path = JsonPath.from(resposne);
		List<String> list = path.getList("data.first_name");
		for(String name : list) {
			System.out.println(name);
		}
	}
	
	@Test(enabled = true)
	public void getCallComplexListValidationJsonPath02() {
		String response = 
		RestAssured
		.given()
		.param("page", "2").
		log().all()
		.get("https://reqres.in/api/users").
		then()
		.extract().response().asString();		
		JsonPath path = JsonPath.from(response);
		List<String> list = path.getList("data.email");
		for(String name : list) {
			System.out.println(name);
		}
		
	}
	
	
}
		
		
		

		
		
				
	
		
	
	
		
