package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class exampleTest1 {

	@Test
	public void test_1()
	{
		given().
		get("/lotto").then().body("lotto.lottoId", equalTo(5));
			
	}
}
