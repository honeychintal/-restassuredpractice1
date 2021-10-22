package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.assertion.BodyMatcher;
import io.restassured.assertion.BodyMatcherGroup;
import io.restassured.response.Response;
public class TestExample {

	//@Test(invocationCount = 10)
	public void test_1()
	{
		Response resp = get("https://reqres.in/api/users?page=2");
		System.out.println("Status code is: "+resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getHeader("content-type"));
		System.out.println(resp.getBody());
		int stat_code = resp.getStatusCode();
		Assert.assertEquals(stat_code, 200);
	}
	//@Test
	public void test_2()	
	{
		baseURI = Properties.apiBaseURI; // baseURI is stored in properties.java class

		given().
		get(Properties.GetEndpoint). // GetEndpoint is stored in properties.java class
		then().
		statusCode(Properties.OkSuccess).
		body("data[2].last_name",equalTo("Funke"));
	}
	//@Test
	public void test_3()
	{
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name","Prajjaval");
		map.put("job","Teacher");
		System.out.println(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request);

		baseURI = Properties.apiBaseURI;

		given().body(request.toJSONString()).
		when().
		post("/api/users").
		then().
		statusCode(Properties.SuccessCreated).log().all();
	}
	@Test
	public void test_body()	//Response Body validation
	{
		baseURI = "https://reqres.in"; // baseURI is stored in properties.java class

		given().
		get("/api/users/2"). // GetEndpoint is stored in properties.java class
		then().
		statusCode(200).assertThat().
		body(Matchers.equalTo("{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}"));
	}
	//@Test
	public void test_meth()// Reusable method for GET call	
	{
		 // baseURI is stored in properties.java class
		String expectedKey="data.email";
		String expectedval="janet.weaver@reqres.in";
		
		demo.TestMethodClass1.getcall(Properties.PutEndpoint, expectedKey, expectedval, Properties.apiBaseURI);

	}
	@Test
	public void test_respbody()// Reusable method for GET call with response body validation
	{
		 // baseURI is stored in properties.java class
		String respbody="{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
		
		demo.TestMethodClass1.getResponseBodyValidation(Properties.PutEndpoint,respbody,Properties.apiBaseURI);

	}
}
