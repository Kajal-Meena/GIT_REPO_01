package Common_Method;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class API_Method_Create_Retry_P 
    {
	public static int StatusCode(String baseURI, String Resource, String RequestBody) 
	{		
		RestAssured.baseURI = baseURI;
		int StatusCode = given().header("Content-Type","application/json").body(RequestBody).
				         when().post(Resource).then().extract().statusCode();
		return StatusCode;
	}
	public static String ResponseBody(String baseURI, String Resource, String RequestBody) 
	{
		RestAssured.baseURI = baseURI;
		String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).
				              when().post(Resource).then().extract().response().asPrettyString();
		return ResponseBody;
		}		
        }