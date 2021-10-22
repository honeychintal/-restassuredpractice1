package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class jsonSchemaValidator {

	@Test
	public void test_get()	
	{
		baseURI =Properties.apiBaseURI;
		
		given().
			get(Properties.GetEndpoint).
		then().assertThat().
		body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
	}
}
