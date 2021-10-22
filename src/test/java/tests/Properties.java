package tests;

public class Properties {

	//base URI of API
	static String apiBaseURI ="https://reqres.in/";
	
	//End point for GET request
	static String GetEndpoint ="api/users?page=2";
	
	//End point for PUT/PATCH request
	static String PutEndpoint ="/api/users/2";
	
	
	//Status codes
	static int OkSuccess =200;
	static int SuccessCreated =201;
	static int noContent =204;	
	
}
