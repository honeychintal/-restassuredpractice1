package demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class TestMethodClass1 {

	public static void getcall(String endp, String expkey, String expval, String baseu)
	{
		baseURI = baseu; 
		
		given().
		get(endp). // GetEndpoint is stored in properties.java class
		then().
		statusCode(200).assertThat().
		body(expkey,equalTo(expval));
		
	}
	
	public static void getResponseBodyValidation(String endp, String respbody, String baseu)
	{
		baseURI = baseu; 
		
		given().
		get(endp). // GetEndpoint is stored in properties.java class
		then().
		statusCode(200).assertThat().
		body(Matchers.equalTo(respbody));
		
	}
}
