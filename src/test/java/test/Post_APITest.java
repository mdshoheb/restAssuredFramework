package test;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_APITest {
	
	@Test(enabled = false)
	public void postPassengerPrettyPrintTest() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\"name\": \"Ross Geller\",\"trips\": 123,\"airline\": 5}")
		.post("https://api.instantwebtools.net/v1/passenger")
		.prettyPrint();
	}
	
	@Test(enabled = false)
	public void postPassengerTestWithFileAsInputStream() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.established", hasItem("1989"))
		.body("airline.id", hasItem(5))
		.body("airline.slogan", hasItem("Sharing the World, Flying Together"))
		.body("name", equalTo("Chandler Bing"));
	}
	
	@Test(enabled = false)
	public void postPassengerTestWithFile() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(5))
		.body("airline.name", hasItem("Eva Air"))
		.body("airline.country", hasItem("Taiwan"))
		.body("trips", equalTo(23));
	}
	
	@Test(enabled = true)
	public static void postPassengerTestWithMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Rachel Green");
		map.put("trips", 180);
		map.put("airline", 5);
		
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(map)
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(5))
		.body("airline.website", hasItem("www.evaair.com"))
		.body("airline.established", hasItem("1989"));
		
	}
}	
	
	
	
	
	
	


