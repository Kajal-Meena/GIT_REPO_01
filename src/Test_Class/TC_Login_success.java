package Test_Class;

import java.io.IOException;

import org.testng.Assert;

import Common_Method.API_Method_Login_success;
import Common_Method.Utility_Method_Login_success;
import Repository.Post_login_success;
import io.restassured.path.json.JsonPath;

public class TC_Login_success 
{
	public static void extractor() throws IOException 
	{
		int StatusCode = API_Method_Login_success.StatusCode(Post_login_success.baseURI(),Post_login_success.Resource(),
				Post_login_success.RequestBody()) ;
    
	    System.out.println(StatusCode);
    
	    String ResponseBody = API_Method_Login_success.ResponseBody(Post_login_success.baseURI(),Post_login_success.Resource(),
	    		Post_login_success.RequestBody()) ;
	    System.out.println(ResponseBody);
	    
	    String RequestBody = Post_login_success.RequestBody() ;
	    
	    Utility_Method_Login_success.EvidenceFile("TC2", RequestBody, ResponseBody, StatusCode);
	    
		JsonPath jspres = new JsonPath(ResponseBody);
		String res_token = jspres.getString("token");
		 
	 	JsonPath jspreq = new JsonPath(RequestBody) ;   
		   String Req_token = jspreq.getString("token") ;
		
		 Assert.assertEquals(res_token,Req_token);
    }
}
