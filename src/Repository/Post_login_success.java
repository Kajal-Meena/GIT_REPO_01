package Repository;

public class Post_login_success 
{
	public static String baseURI() 
	{
	String baseURI = "https://reqres.in" ;
	return baseURI ;
	}
	public static String Resource() 
	{
	String Resource = "/api/login" ;
	return Resource ;
	}
	public static String RequestBody() 
	{
		String RequestBody = 
				"{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}" ;
		return RequestBody ;
	}
}
