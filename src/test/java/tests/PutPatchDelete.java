package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDelete {

	@Test
	public void test_Put()
	{

		JSONObject request = new JSONObject();
		request.put("name", "Prajjaval");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI =Properties.apiBaseURI;
		
		given().body(request.toJSONString()).
		when().
		put(Properties.PutEndpoint).
		then().
		statusCode(Properties.OkSuccess).log().all();
	}
	
	@Test
	public void test_Patch()
	{

		JSONObject request = new JSONObject();
		request.put("name", "Prajjaval");
		//request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI =Properties.apiBaseURI;
		
		given().body(request.toJSONString()).
		when().
		patch(Properties.PutEndpoint).
		then().
		statusCode(Properties.OkSuccess).log().all();
	}
	
	@Test
	public void test_Delete()
	{
	
		baseURI =Properties.apiBaseURI;
		
		given().
		when().
		delete(Properties.PutEndpoint).
		then().
		statusCode(Properties.noContent).log().all();
	}
}
