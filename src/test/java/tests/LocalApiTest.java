package tests;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
public class LocalApiTest {

	@Test
	public void getreq()
	{
		
		baseURI ="http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
	}
	//@Test
	public void postreq()
	{
		
		baseURI ="http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "Bill");
		request.put("lastname", "Gates");
		request.put("subjectId", 1);
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201);
	}
	
	//@Test
	public void putreq_update()
	{
		
		baseURI ="http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "Bill");
		request.put("lastname", "Gates");
		request.put("subjectId", 1);
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/4").
		then().
		statusCode(200);
	}
	@Test
	public void patchreq_update()
	{
		
		baseURI ="http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "Melinda");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/4").
		then().
		statusCode(200);
	}
}
