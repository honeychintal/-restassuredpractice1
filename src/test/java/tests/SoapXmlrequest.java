package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.*;

public class SoapXmlrequest {

	@Test
	public void validate_soapXML() throws IOException{

		File file = new File("./soapRequest/add.xml");

		if(file.exists())
			System.out.println(" >> File exists");

		FileInputStream fileinput = new FileInputStream(file);
		String request_body = IOUtils.toString(fileinput,"UTF-8");

		baseURI ="http://www.dneonline.com";	

		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(request_body).
		when().
		post("/calculator.asmx").
		then().
		statusCode(200).log().all();
	}
}
