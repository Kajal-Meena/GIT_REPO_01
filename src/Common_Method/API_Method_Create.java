package Common_Method;

import io.restassured.RestAssured ;
import static io.restassured.RestAssured.given ;

public class API_Method_Create 
{
	public static int StatusCode(String baseURI , String Resource , String RequestBody) 
	{
		RestAssured.baseURI = "https://reqres.in" ;	
		int StatusCode = given().header("Content-Type","Application/Json").body(RequestBody).when().post(Resource).
				              then().extract().statusCode() ;
		return StatusCode ;
	}
	public static String ResponseBody(String baseURI , String Resource , String RequestBody)
	{
		RestAssured.baseURI = "https://reqres.in" ;
		String ResponseBody = given().header("Content-Type","Application/Json").body(RequestBody).when().post(Resource).
	              then().extract().response().asPrettyString();
		return ResponseBody ;
		
	}
	}
